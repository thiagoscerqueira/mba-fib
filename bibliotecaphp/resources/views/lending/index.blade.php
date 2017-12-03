@extends('layouts.app')@section('content')

    @if (Session::has('success'))
        <div class="alert alert-success">
            <ul>
                <li>{{ Session::get('success') }}</li>
            </ul>
        </div>
    @endif

<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="panel panel-default">
                <ol class="breadcrumb panel-heading">
                    <li class="active">Empr&eacute;stimos</li>
                </ol>
                <div class="panel-body">
                    @if (!Auth::user()->isAdmin())
                    <div class="form-group" style="float: left;">
                        <p><a href="{{route('lending.add')}}" class="btn btn-info btn-sm"><i class="glyphicon glyphicon-plus"></i> Solicitar Novo</a></p>
                    </div>
                    @endif
                    <table class="table table-bordered table-striped">
                        <thead>
                            <tr>
                                <th>Cod</th>
                                <th>Usu&aacute;rio</th>
                                <th>Data de Retirada</th>
                                <th>Livros Retirados</th>
                                <th>Data Limite de Devolução</th>
                                <th>Data de Devolução</th>
                                @if (Auth::user()->isAdmin())<th>Ação</th>@endif
                            </tr>
                        </thead>
                        <tbody>
                            @foreach($lendings as $lending)
                                <tr>
                                    <th scope="row" class="text-center">{{ $lending->id }}</th>
                                    <td>{{ $lending->user->name }}</td>
                                    <td>{{ date('d/m/Y H:i:s', strtotime($lending->date_start) ) }}</td>
                                    <td>{{ $lending->books->pluck('title')->implode(', ')  }}</td>
                                    <td>{{ date('d/m/Y H:i:s', strtotime($lending->date_end) ) }}</td>
                                    <td>@if ($lending->date_finish != null) {{ date('d/m/Y H:i:s', strtotime($lending->date_finish) ) }}@endif</td>
                                    @if (Auth::user()->isAdmin())
                                    <td width="155" class="text-center">
                                        @if ($lending->date_finish == null)
                                        <form class="form-inline" action="{{ route('lending.return') }}" method="POST">
                                            {{ csrf_field() }}
                                            <input type="hidden" name="_method" value="post">
                                            <input type="hidden" name="id" value="{{$lending->id}}">
                                            <button type="submit" class="btn btn-danger">Registrar Devolução</button>
                                        </form>
                                        @else -
                                        @endif
                                    </td>
                                    @endif
                                </tr>
                            @endforeach
                        </tbody>
                    </table>
                    @if(!isset($search))
                    <div align="center">
                        {!! $lendings->links() !!}
                    </div>
                    @endif
                </div>
            </div>
        </div>
    </div>
</div>
@endsection