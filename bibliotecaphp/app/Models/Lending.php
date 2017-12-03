<?php
/**
 * Created by PhpStorm.
 * User: php
 * Date: 18/11/17
 * Time: 10:23
 */

namespace App\Models;

use Illuminate\Database\Eloquent\Model;

class Lending extends Model
{
    protected $fillable = ['date_start', 'date_end', 'date_finish'];

    public function user() {
        return $this->belongsTo('App\User');
    }
    public function books() {
        return $this->belongsToMany('App\Models\Book', 'books_lendings');
    }
}