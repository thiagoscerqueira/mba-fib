<?php
/**
 * Created by PhpStorm.
 * User: php
 * Date: 18/11/17
 * Time: 10:23
 */

namespace App\Models;

use Illuminate\Database\Eloquent\Model;

class Book extends Model
{
    protected $fillable = ['title', 'description', 'image'];

    public function authors() {
        return $this->belongsToMany('App\Models\Author', 'books_authors');
    }

    public function lendings() {
        return $this->belongsToMany('App\Models\Lending', 'books_lendings');
    }
}