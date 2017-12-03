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
                        <li><a href="{{route('lending.index')}}">Empr&eacute;stimos</a></li>
                        <li class="active">Novo</li>
                    </ol>
                    <div class="panel-body">
                        @if (!$books->isEmpty())
                            <form action="{{ route('lending.save') }}" method="POST" enctype="multipart/form-data">
                                {{ csrf_field() }}

                                <div class="form-group">
                                    <label for="name">Selecione os livros desejados</label>
                                    <select class="image-picker show-labels show-html"
                                            name="book[]"
                                            multiple=""
                                            title="Livros">
                                        @foreach($books as $book)
                                            <option data-img-label="<strong>{{ $book->title }}</strong> <br> {{ $book->description }}"
                                                    data-img-src="http://localhost/images/book/{{ $book->image }}"
                                                    value="{{ $book->id }}">{{ $book->title }}</option>
                                        @endforeach()
                                    </select>
                                    <p class="help-block">Use Crtl para selecionar.</p>
                                </div>
                                <br/>
                                <button type="submit" class="btn btn-primary">Salvar</button>
                            </form>
                        @else
                            <div class="alert alert-danger">Não h&aacute; livros dispon&iacute;veis. Todos os livros do
                                estoque estão emprestados.
                            </div>
                        @endif
                    </div>
                </div>
            </div>
        </div>
    </div>
@endsection

@section('scripts')
    <script>$("select").imagepicker({show_label: true});</script>
@endsection