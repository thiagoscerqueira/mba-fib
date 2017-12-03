<?php

namespace App;

use Illuminate\Notifications\Notifiable;
use Illuminate\Foundation\Auth\User as Authenticatable;

class User extends Authenticatable
{
    use Notifiable;

    /**
     * The attributes that are mass assignable.
     *
     * @var array
     */
    protected $fillable = [
        'name', 'email', 'password','role'
    ];

    /**
     * The attributes that should be hidden for arrays.
     *
     * @var array
     */
    protected $hidden = [
        'password', 'remember_token',
    ];

    public function lendings()    {
        return $this->hasMany('App\Models\Lending');
    }

    public function autorizaAdmin() {
        return $this->isAdmin() || abort(401, "Apenas administradores tem acesso a este recurso");
    }

    public function isAdmin() {
        return $this->role == 1;
    }
}
