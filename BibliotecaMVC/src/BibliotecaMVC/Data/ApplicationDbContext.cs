using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Identity.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore;
using BibliotecaMVC.Models;

namespace BibliotecaMVC.Data
{
    public class ApplicationDbContext : IdentityDbContext<ApplicationUser>
    {
        public ApplicationDbContext(DbContextOptions<ApplicationDbContext> options)
            : base(options)
        {
        }

        protected override void OnModelCreating(ModelBuilder builder)
        {
            builder.Entity<LivroAutor>()
                .HasKey(la => new { la.LivroID, la.AutorID });

            builder.Entity<LivroAutor>()
                .HasOne(livroAutorReference => livroAutorReference.Livro)
                .WithMany(livroReferece => livroReferece.LivroAutores)
                .HasForeignKey(livroAutorReference => livroAutorReference.LivroID);

            builder.Entity<LivroAutor>()
               .HasOne(livroAutorReference => livroAutorReference.Autor)
               .WithMany(autorReferece => autorReferece.LivroAutores)
               .HasForeignKey(livroAutorReference => livroAutorReference.AutorID);


            builder.Entity<LivroEmprestimo>()
               .HasKey(le => new { le.LivroID, le.EmprestimoID });

            builder.Entity<LivroEmprestimo>()
                .HasOne(livroEmpReference => livroEmpReference.Livro)
                .WithMany(livroReferece => livroReferece.LivroEmprestimos)
                .HasForeignKey(livroEmpReference => livroEmpReference.LivroID);

            builder.Entity<LivroEmprestimo>()
               .HasOne(livroEmpReference => livroEmpReference.Emprestimo)
               .WithMany(empReferece => empReferece.LivroEmprestimo)
               .HasForeignKey(livroEmpReference => livroEmpReference.EmprestimoID);

            base.OnModelCreating(builder);            
        }

        public DbSet<Livro> Livro { get; set; }

        public DbSet<Autor> Autor { get; set; }

        public DbSet<LivroAutor> LivroAutor { get; set; }

        public DbSet<Usuario> Usuario { get; set; }

        public DbSet<Emprestimo> Emprestimo { get; set; }
    }
}
