<?php
namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Book;
use App\Models\Author;
use Validator;

class BookController extends Controller
{

    private $path = 'images/book';

    public function __construct()
    {
        $this->middleware('auth');
    }

    public function index(Request $request)
    {
        $request->user()->autorizaAdmin();

		$books = Book::paginate(10);
	   	return view('book.index', compact('books'));
    }

    public function add()
    {
        $authors = Author::get();
    	return view('book.add', compact('authors'));
    }

    public function save(Request $request)
    {
        $messages = ['title.required' => 'Atributo Titulo deve ser informado.'];

        $validator = Validator::make($request->all(), [
            'title' => 'required'
        ], $messages);

        if($validator->fails()) {
            return back()
                ->withErrors($validator)
                ->withInput();
        }

        $fileName = NULL;

        if (!empty($request->file('image')) && $request->file('image')->isValid()) {
            $fileName = time() . '.' . $request->file('image')->getClientOriginalExtension();
            $request->file('image')->move($this->path, $fileName);
        }

        $book = Book::create([
    		'title' => $request->input('title'),
            'description' => $request->input('description'),
            'image' => $fileName,
		]);

        $book->authors()->sync($request->input('author'));

    	return redirect()->route('book.index');
    }

    public function edit($id)
    {
        $book = Book::find($id);
        $authors = Author::get();

        if(!$book){
            return redirect()->route('book.index');
        }

        $selected_authors[] = [];

        foreach ($book->authors as $author) {
            $selected_authors[] = $author->pivot->author_id;
        }

        return view('book.edit', compact('book','authors', 'selected_authors'));
    }

    public function update(Request $request, $id)
    {
        $messages = ['title.required' => 'Atributo Titulo deve ser informado.'];

        $validator = Validator::make($request->all(), [
            'title' => 'required'
        ], $messages);

        if($validator->fails()) {
            return back()
                ->withErrors($validator)
                ->withInput();
        }

        $fileName = NULL;

        if (!empty($request->file('image')) && $request->file('image')->isValid()) {
            if(!empty($request->input('deleteimage')) && file_exists($this->path . '/' . $request->input('deleteimage'))){
                unlink($this->path . '/' . $request->input('deleteimage'));
            }
            $fileName = time() . '.' . $request->file('image')->getClientOriginalExtension();
            $request->file('image')->move($this->path, $fileName);
        }


        if(!$fileName) {
            $update = [
                'title' => $request->input('title'),
                'description' => $request->input('description')
            ];
        } else {
            $update = [
                'title' => $request->input('title'),
                'description' => $request->input('description'),
                'image' => $fileName
            ];
        }

        $book = Book::find($id);
        $author = $request->input('author');
        $book->authors()->sync($author);

        $book->update($update);
        
        return redirect()->route('book.index');
    }

    public function delete($id)
    {
        $book =  Book::find($id);

        if($book){
            $book->authors()->detach();
            $result = $book->delete();
        }

        return redirect()->route('book.index');
    }

    public function search(Request $request)
    {
        $title = $request->input('title');

        if (!$title) {
            return redirect()->route('book.index');
        }

        $search = TRUE;
        $books = Book::where('title', 'like', '%' . $title . '%')->get();
        return view('book.index', compact('books', 'search'));
    }
}
