using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace BibliotecaMVC.Models
{
    public class Usuario
    {
        public int UsuarioID { get; set; }

        [Required(ErrorMessage = "O Nome é obrigatório")]
        [StringLength(100, ErrorMessage = "O campo {0} deve ter no máximo {1} caracteres")]
        public string Nome { get; set; }

        [StringLength(20, ErrorMessage = "O campo {0} deve ter no máximo {1} caracteres")]
        public string Telefone { get; set; }

        [Required(ErrorMessage = "O E-mail é obrigatório")]
        [Display(Name = "E-mail")]
        [EmailAddress(ErrorMessage = "E-mail inválido")]
        [StringLength(100, ErrorMessage = "O campo {0} deve ter no máximo {1} caracteres")]
        public string Email { get; set; }

        [Required(ErrorMessage = "A Senha é obrigatória")]
        [StringLength(20, ErrorMessage = "O campo {0} deve ter no máximo {1} caracteres")]
        public string Senha { get; set; }

        public virtual ICollection<Emprestimo> Emprestimo { get; set; }
    }
}
