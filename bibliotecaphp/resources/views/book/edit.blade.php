@extends('layouts.app')

@section('content')

    @if ($errors->any())
        <div class="alert alert-danger">
            <ul>
                @foreach ($errors->all() as $error)
                    <li>{{ $error }}</li>
                @endforeach
            </ul>
        </div>
    @endif

<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="panel panel-default">
            	<ol class="breadcrumb panel-heading">
                	<li><a href="{{route('book.index')}}">Livros</a></li>
                	<li class="active">Editar</li>
                </ol>
                <div class="panel-body">
	                <form action="{{ route('book.update', $book->id) }}" method="POST" enctype="multipart/form-data">
	                	{{ csrf_field() }}
						<div class="form-group">
						  	<label for="name">Titulo</label>
						    <input type="text" class="form-control" name="title" id="title" placeholder="Titulo" value="{{ old('title', $book->title ) }}">
						</div>
                        <div class="form-group">
                            <label for="surname">Descricao</label>
                            <input type="text" class="form-control" name="description" id="description" placeholder="Descricao" value="{{ old('description', $book->description ) }}">
                        </div>
                        <div class="form-group">
                            <label for="name">Autores</label>
                            <select name="author[]" class="form-control selectpicker" multiple="" data-live-search="true" title="Categorias">
                                @foreach($authors as $author)
                                    <option value="{{ $author->id }}" <?= in_array($author->id, $selected_authors) ? "selected" : NULL ; ?>>{{ $author->name }} {{ $author->surname }}</option>
                                @endforeach()
                            </select>
                            <p class="help-block">Use Crtl para selecionar.</p>
                        </div>
                        @if ($book->image != null)
                        <div class="form-group">
                            <img src="http://localhost/images/book/{{ $book->image }}"  width="10%" />
                            <input type="hidden" name="deleteimage" value="{{ $book->image }}">
                        </div>
                        @endif
                        <div class="control-group">
                            <div class="controls">
                                <input name="image" type="file">
                            </div>
                        </div>
						<br />
						<button type="submit" class="btn btn-primary">Salvar</button>
	                </form>
                </div>
            </div>
        </div>
    </div>
</div>
@endsection
