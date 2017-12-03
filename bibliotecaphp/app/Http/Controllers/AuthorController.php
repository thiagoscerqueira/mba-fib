<?php
namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Author;
use Validator;

class AuthorController extends Controller
{

    public function __construct()
    {
        $this->middleware('auth');
    }

    public function index(Request $request)
    {
        $request->user()->autorizaAdmin();

		$authors = Author::paginate(10);
	   	return view('author.index', compact('authors'));
    }

    public function add()
    {
    	return view('author.add');
    }

    public function save(Request $request)
    {
        $messages = ['name.required' => 'Atributo Nome deve ser informado.'];

        $validator = Validator::make($request->all(), [
            'name' => 'required'
        ], $messages);

        if($validator->fails()) {
            return back()
                ->withErrors($validator)
                ->withInput();
        }

        $result = Author::create([
    		'name' => $request->input('name'),
            'surname' => $request->input('surname')
		]);

    	return redirect()->route('author.index');
    }

    public function edit($id)
    {
        $author = Author::find($id);

        if(!$author){
            return redirect()->route('author.index');
        }

        return view('author.edit', compact('author'));
    }

    public function update(Request $request, $id)
    {
        $messages = ['name.required' => 'Atributo Nome deve ser informado.'];

        $validator = Validator::make($request->all(), [
            'name' => 'required'
        ], $messages);

        if($validator->fails()) {
            return back()
                ->withErrors($validator)
                ->withInput();
        }

            $update =[
                'name' =>  $request->input('name'),
                'surname' => $request->input('surname'),
            ];


        $result = Author::find($id)->update($update);
        
        return redirect()->route('author.index');
    }

    public function delete($id)
    {
        $author =  Author::find($id);

        if($author){
            $author->books()->detach();
            $result = $author->delete();
        }

        return redirect()->route('author.index');
    }

    public function search(Request $request)
    {
        $name = $request->input('name');

        if (!$name) {
            return redirect()->route('author.index');
        }

        $search = TRUE;
        $authors = Author::where('name', 'like', '%' . $name . '%')->get();
        return view('author.index', compact('authors', 'search'));
    }
}
