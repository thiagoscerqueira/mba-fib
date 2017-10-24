using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.Rendering;
using Microsoft.EntityFrameworkCore;
using BibliotecaMVC.Data;
using BibliotecaMVC.Models;
using Microsoft.AspNetCore.Identity;

namespace BibliotecaMVC.Controllers
{
    public class EmprestimosController : Controller
    {
        private readonly ApplicationDbContext _context;
        private readonly UserManager<ApplicationUser> _userManager;

        public EmprestimosController(ApplicationDbContext context, UserManager<ApplicationUser> userManager)
        {
            _context = context;
            _userManager = userManager; 
        }

        // GET: Emprestimos
        public async Task<IActionResult> Index()
        {
            List<Emprestimo> listaEmprestimos = new List<Emprestimo>();
            // Verificamos se o usuário está logado
            if (User.Identity.IsAuthenticated)
            {
                // Pegar ID do Usuário
                string userID = _userManager.GetUserId(HttpContext.User);
                listaEmprestimos = await _context.Emprestimo.Include(e => e.Usuario)
                .Where(c => c.ApplicationUserId == userID)

                .ToListAsync();

            }
            return View("Index", listaEmprestimos);
        }

        // GET: Emprestimos/Details/5
        public async Task<IActionResult> Details(int? id)
        {
            if (id == null)
            {
                return NotFound();
            }

            var emprestimo = await _context
                .Emprestimo
                .Include(e => e.LivroEmprestimo)
                .ThenInclude(le => le.Livro)            
                .ThenInclude(li => li.LivroAutores)
                .ThenInclude(la => la.Autor)
                .SingleOrDefaultAsync(m => m.EmprestimoID == id);
            if (emprestimo == null)
            {
                return NotFound();
            }

            return View(emprestimo);
        }

        // GET: Emprestimos/Create
        public IActionResult Create()
        {
            ViewData["ApplicationUserId"] = new SelectList(_context.Users, "Id", "Id");
            ViewData["UsuarioID"] = new SelectList(_context.Usuario, "UsuarioID", "Email");
            return View();
        }

        // POST: Emprestimos/Create
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> Create([Bind("EmprestimoID,ApplicationUserId,DataDevolucao,DataFim,DataInicio,UsuarioID")] Emprestimo emprestimo)
        {
            if (ModelState.IsValid)
            {
                _context.Add(emprestimo);
                await _context.SaveChangesAsync();
                return RedirectToAction("Index");
            }
            ViewData["ApplicationUserId"] = new SelectList(_context.Users, "Id", "Id", emprestimo.ApplicationUserId);
            ViewData["UsuarioID"] = new SelectList(_context.Usuario, "UsuarioID", "Email", emprestimo.UsuarioID);
            return View(emprestimo);
        }

        // GET: Emprestimos/Edit/5
        public async Task<IActionResult> Edit(int? id)
        {
            if (id == null)
            {
                return NotFound();
            }

            var emprestimo = await _context.Emprestimo.SingleOrDefaultAsync(m => m.EmprestimoID == id);
            if (emprestimo == null)
            {
                return NotFound();
            }
            ViewData["ApplicationUserId"] = new SelectList(_context.Users, "Id", "Id", emprestimo.ApplicationUserId);
            ViewData["UsuarioID"] = new SelectList(_context.Usuario, "UsuarioID", "Email", emprestimo.UsuarioID);
            return View(emprestimo);
        }

        // POST: Emprestimos/Edit/5
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> Edit(int id, [Bind("EmprestimoID,ApplicationUserId,DataDevolucao,DataFim,DataInicio,UsuarioID")] Emprestimo emprestimo)
        {
            if (id != emprestimo.EmprestimoID)
            {
                return NotFound();
            }

            if (ModelState.IsValid)
            {
                try
                {
                    _context.Update(emprestimo);
                    await _context.SaveChangesAsync();
                }
                catch (DbUpdateConcurrencyException)
                {
                    if (!EmprestimoExists(emprestimo.EmprestimoID))
                    {
                        return NotFound();
                    }
                    else
                    {
                        throw;
                    }
                }
                return RedirectToAction("Index");
            }
            ViewData["ApplicationUserId"] = new SelectList(_context.Users, "Id", "Id", emprestimo.ApplicationUserId);
            ViewData["UsuarioID"] = new SelectList(_context.Usuario, "UsuarioID", "Email", emprestimo.UsuarioID);
            return View(emprestimo);
        }

        // GET: Emprestimos/Delete/5
        public async Task<IActionResult> Delete(int? id)
        {
            if (id == null)
            {
                return NotFound();
            }

            var emprestimo = await _context.Emprestimo.SingleOrDefaultAsync(m => m.EmprestimoID == id);
            if (emprestimo == null)
            {
                return NotFound();
            }

            return View(emprestimo);
        }

        // POST: Emprestimos/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> DeleteConfirmed(int id)
        {
            var emprestimo = await _context.Emprestimo.SingleOrDefaultAsync(m => m.EmprestimoID == id);
            _context.Emprestimo.Remove(emprestimo);
            await _context.SaveChangesAsync();
            return RedirectToAction("Index");
        }

        private bool EmprestimoExists(int id)
        {
            return _context.Emprestimo.Any(e => e.EmprestimoID == id);
        }

        public async Task<IActionResult> DevolverLivros(int? id)
        {
            if (id != null)
            {
                Emprestimo emprestimo = _context.Emprestimo.FirstOrDefault(e => e.EmprestimoID == id);
                emprestimo.DataDevolucao = DateTime.Now.ToString("dd/MM/yyyy");
                _context.Update(emprestimo);
                _context.SaveChanges();
            }
            return await Index();
        }
    }
}
