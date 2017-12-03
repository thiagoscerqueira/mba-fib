<?php
/**
 * Created by PhpStorm.
 * User: php
 * Date: 18/11/17
 * Time: 10:23
 */

namespace App\Models;

use Illuminate\Database\Eloquent\Model;

class Author extends Model
{
    protected $fillable = ['name', 'surname'];

    public function books() {
        return $this->belongsToMany('App\Models\Book', 'books_authors');
    }

}