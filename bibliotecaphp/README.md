## Projeto Biblioteca MVC desenvolvido em PHP - Framework Laravel

### Funcionalidades:

- Cadastro de Livros
- Cadastro de Autores
- Empréstimo de Livros


**Observação** : para entrar nos cadastros de livros e autores, o usuário deve ter o campo role = 1 na tabela user. Por padrão, novos usuários cadastrados terão o campo role = 0, e não visualizam os cadastros de livros e autores no menu.


### Recursos:

- Valida campos obrigatórios nos cadastros de livros e autores e caso ocorra erro na validação apresenta mensagens de erro ao usuário e mantendo os valores digitados no form
- Upload de foto dos livros
- Controle de acesso: Apenas usuário administrador pode acessar cadastro dos livros e autores
- Controle de acesso: Apenas usuário administrador pode registrar devolução de livros
- Controle de acesso: Apenas usuário não administrador pode solicitar novo empréstimo de livro
- Controle de acesso: Usuário administrador visualiza empréstimo de todos os usuários
- Controle de acesso: Usuário não administrador visualiza apenas seus empréstimos solicitados (pendentes de devolução e devolvidos)
- Ao efetuar novo empréstimo ou devolução, apresenta mensagem de sucesso
- Ao efetuar novo empréstimo, apresenta para seleção apenas livros disponíveis, que não estão emprestados a nenhum usuário no momento
- Ao efetuar novo empréstimo, o usuário seleciona o livro pela foto, visualizando também o título e a descrição de cada um
- Ao efetuar novo empréstimo, calcula a data máxima de devolução (data atual mais 7 dias)
- Valida se pelo menos um livro foi selecionado ao salvar novo empréstimo
