using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace BibliotecaMVC.Models
{
    public class LivroAutor
    {
        public int LivroID { get; set; }
        public Livro Livro { get; set; }

        public int AutorID { get; set; }
        public Autor Autor { get; set; }
    }
}
