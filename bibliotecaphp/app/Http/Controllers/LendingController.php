<?php

namespace App\Http\Controllers;

use App\Models\Book;
use App\Models\Lending;
use Illuminate\Http\Request;
use Validator;

class LendingController extends Controller
{

    public function __construct()
    {
        $this->middleware('auth');
    }

    public function index(Request $request)
    {
        if ($request->user()->isAdmin()) {
            $lendings = Lending::orderBy('date_start', 'desc')->paginate(10);
        } else {
            $lendings = Lending::whereHas('user', function ($q) use (&$request) {
                $q->where('id', $request->user()->id);
            })->orderBy('date_start', 'desc')->paginate(10);
        }

        return view('lending.index', compact('lendings'));
    }

    public function devolver(Request $request)
    {
        $lending = Lending::find($request->input('id'));
        $lending->date_finish = now();
        $lending->save();

        return redirect()->back()->with('success', 'Devolução registrada com sucesso. Os livros devolvidos j&aacute; estão dispon&iacute;veis para novo empr&eacute;stimo');
    }

    public function add()
    {
        $books = Book::get();
        $lent_book_ids = $this->procuraLivrosEmprestados();
        $books = $this->desconsideraLivrosEmprestados($books, $lent_book_ids);

        return view('lending.add', compact('books'));
    }

    /**
     * @param $book_ids
     */
    public function procuraLivrosEmprestados()
    {
        $lendingsWithNoReturn = Lending::whereNull('date_finish')->get();
        $book_ids[] = [];
        foreach ($lendingsWithNoReturn as $lending) {
            $book_ids[] = $lending->books()->pluck('id');
        }

        return $book_ids;
    }

    /**
     * @param $books
     * @return mixed
     */
    public function desconsideraLivrosEmprestados($books, $lent_book_ids)
    {
        $books = $books->filter(function ($value, $key) use (&$lent_book_ids) {

            foreach ($lent_book_ids as $book_id) {
                foreach ($book_id as $b) {
                    if ($b == $value->id) {
                        return false;
                    }
                }
            }

            return true;
        });
        return $books;
    }

    public function save(Request $request)
    {
        if (empty($request->input('book'))) {
            return back()
                ->withErrors(array('message' => 'Necess&aacute;rio selecionar ao menos um livro.'))
                ->withInput();
        }

        $lending = new Lending([
            'date_start' => now(),
            'date_end' => date('Y-m-d H:i:s', strtotime("+7 day")),
        ]);

        $lending->user()->associate($request->user());
        $lending->save();

        $lending->books()->sync($request->input('book'));

        return redirect()->route('lending.index')->with('success', 'Empr&eacute;stimos solicitados com sucesso');
    }

}
