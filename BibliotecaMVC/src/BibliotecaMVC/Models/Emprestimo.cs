using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace BibliotecaMVC.Models
{
    public class Emprestimo
    {
        [Key]
        public int EmprestimoID { get; set; }

        public int UsuarioID { get; set; }
        public virtual Usuario Usuario {get; set;}

        public string ApplicationUserId { get; set; }
        public virtual ApplicationUser ApplicationUser { get; set; }

        [Display(Name = "Data Início")]
        public string DataInicio { get; set; }

        [Display(Name = "Data Fim")]
        public string DataFim { get; set; }

        [Display(Name = "Data de Devolução")]
        public string DataDevolucao { get; set; }

        public ICollection<LivroEmprestimo> LivroEmprestimo { get; set; }

    }
}
