import Binary_Search_Tree
import tkinter as tk
from PIL import Image, ImageTk

# Classe de Applicação
class BSTApp:
    def __init__(self):
        self.root = tk.Tk()
        
        try:
            self.root.iconbitmap("cat.ico") # mudando o icon do app
        except:
            pass
        
        self.root.title("Binary Search Tree")
        self.root.geometry("600x400")
        self.root.resizable(False, False)
        self.root.configure(background="#F8A19F")

        self.font = ("Consolas", 12)

        self.bst = None

    def criarBotao(self, text, fg, bg, highlightcolor, command=None):
        button = tk.Button(self.root, text=text, font=self.font, fg=fg, bg=bg, highlightcolor=highlightcolor, command=command)
        button.pack(pady=5)
        return button

    # Criar uma BST
    def criarBST(self):
        # Limpar a tela
        for widget in self.root.winfo_children():
            widget.destroy()

        self.bst = Binary_Search_Tree.BinarySearchTree()

        entrada= tk.Entry(self.root)
        entrada.pack(pady=5)

        def inserir():
            valor = entrada.get()
            if valor:
                self.bst.insert(valor)
                entrada.delete(0, 'end')  # Limpar o campo de entrada

                # Mostrar a mensagem "chave adicionada"
                msg = tk.Label(self.root, text="Chave adicionada", font=("Consolas", 10), fg="#CD4662", bg="#F8A19F")
                msg.pack()

        # botão 'Inserir' que chama a função 'inserir' quando pressionado
        inserir_button = self.criarBotao("Inserir", "#CD4662", "#FFF5D1", "#7E1037", inserir)
        voltar_button = self.criarBotao("Voltar", "#CD4662", "#FFF5D1", "#7E1037", self.telaInicial)

    # Mostrar as informações da árvore
    def Informacoes(self):
        # Limpar tela
        for widget in self.root.winfo_children():
            widget.destroy()
        
        # Caso a árvore esteja vazia
        if self.bst is None:
            msg = tk.Label(self.root, text="Nenhuma árvore criada", font=("Consolas", 12), fg="#CD4662", bg="#F8A19F")
            msg.pack()
        else:
            tamanho = self.bst.tamanho()
            altura = self.bst.altura()
            menor = self.bst.min()
            maior = self.bst.max()
            
            info = f"Tamanho: {tamanho}\nAltura: {altura}\nMenor: {menor}\nMaior: {maior}"
            label = tk.Label(self.root, text=info, font=("Consolas", 12), fg="#CD4662", bg="#F8A19F")
            label.pack()
        
        voltar_button = self.criarBotao("Voltar", "#CD4662", "#FFF5D1", "#7E1037", self.telaInicial)
    
    # Mostra o Internal Path Length da árvore
    def InternalPathLength(self):
        # limpar tela
        for widget in self.root.winfo_children():
            widget.destroy()
        
        if self.bst is None:
            msg = tk.Label(self.root, text="Nenhuma árvore criada", font=("Consolas", 12), fg="#CD4662", bg="#F8A19F")
            msg.pack()
        else:
            path = self.bst.internalPathLenght()
            info = f"Internal Path Length da BST: {path}"
            label = tk.Label(self.root, text=info, font=("Consolas", 12), fg="#CD4662", bg="#F8A19F")
            label.pack()
    
        voltar_button = self.criarBotao("Voltar", "#CD4662", "#FFF5D1", "#7E1037", self.telaInicial)
    
    # Diz se a árvore está balanceada ou não  
    def Balanceamento(self):
        # limpar tela
        for widget in self.root.winfo_children():
            widget.destroy()
        
        # caso a árvore não tenha sido criada
        if self.bst is None:
            msg = tk.Label(self.root, text="Nenhuma árvore criada", font=("Consolas", 12), fg="#CD4662", bg="#F8A19F")
            msg.pack()
        else:
            balanceada = self.bst.isTreeBalanced()
            info = f"Balanceamento da Árvore: "
            if balanceada is True:
                info += "Está Balanceada! :D\n"
            else:
                info += "Não está balanceada :( \n"
            label = tk.Label(self.root, text= info, font=("Consolas", 12), fg="#CD4662", bg="#F8A19F")
            label.pack()
            
        voltar_button = self.criarBotao("Voltar", "#CD4662", "#FFF5D1", "#7E1037", self.telaInicial)
    
    # Mostra as formas de percorrer a árvore
    def Travessias(self):
        # limpar tela 
        for widget in self.root.winfo_children():
            widget.destroy()
        
        # caso a árvore não tenha sido criada
        if self.bst is None:
            msg = tk.Label(self.root, text="Nenhuma árvore criada", font=("Consolas", 12), fg="#CD4662", bg="#F8A19F")
            msg.pack()
        else:
            def show_traversal(traversal_func):
                traversal = traversal_func()
                traversal_label = tk.Label(self.root, text=str(traversal), font=("Consolas", 12), fg="#CD4662", bg="#F8A19F")
                traversal_label.pack()

            in_order_button = self.criarBotao("Em ordem", "#CD4662", "#FFF5D1", "#7E1037", lambda: show_traversal(self.bst.inOrder))
            pre_order_button = self.criarBotao("Pré-ordem", "#CD4662", "#FFF5D1", "#7E1037", lambda: show_traversal(self.bst.preOrder))
            post_order_button = self.criarBotao("Pós-ordem", "#CD4662", "#FFF5D1", "#7E1037", lambda: show_traversal(self.bst.posOrder))
            level_order_button = self.criarBotao("Level order", "#CD4662", "#FFF5D1", "#7E1037", lambda: show_traversal(self.bst.levelOrder))

        voltar_button = self.criarBotao("Voltar", "#CD4662", "#FFF5D1", "#7E1037", self.telaInicial)
    
    # Cria e exibe a tela inicial
    def telaInicial(self):
        # Limpar a tela
        for widget in self.root.winfo_children():
            widget.destroy()

        # tela inicial
        label = tk.Label(self.root, text="Binary Search Tree", font=("Consolas", 20), fg="#CD4662", bg="#F8A19F")
        label.pack()
        welcome = tk.Label(self.root, text="Bem-vindo(a)! :)", font=("Consolas", 15), fg="#CD4662", bg="#F8A19F")
        welcome.pack(pady=20)

        # Adicionar a imagem
        imagem = Image.open("cat.png~")  
        imagem = imagem.convert("RGBA") 
        imagem = imagem.resize((180, 180), Image.LANCZOS)  

        # Converter a cor hexadecimal para RGB
        cor_hex = "#F8A19F"
        cor_rgb = tuple(int(cor_hex[i:i+2], 16) for i in (1, 3, 5)) + (255,)

        # Criar uma nova imagem com a cor de fundo desejada
        fundo = Image.new('RGBA', imagem.size, cor_rgb)

        # Colar a imagem original sobre o fundo
        imagem_com_fundo = Image.alpha_composite(fundo, imagem)

        foto = ImageTk.PhotoImage(imagem_com_fundo)
        imagem_label = tk.Label(self.root, image=foto)
        imagem_label.image = foto  
        imagem_label.place(x=25, y=200) 

        self.criarBotao("Criar uma Binary Search Tree - BST", "#CD4662", "#FFF5D1", "#7E1037", self.criarBST)
        # Add command argument to the buttons below as per your requirements
        self.criarBotao("Informações da Árvore", "#CD4662", "#FFF5D1", "#7E1037", self.Informacoes)
        self.criarBotao("InternalPathLength", "#CD4662", "#FFF5D1", "#7E1037",self.InternalPathLength)
        self.criarBotao("Balanceamento", "#CD4662", "#FFF5D1", "#7E1037", self.Balanceamento)
        self.criarBotao("Travessias", "#CD4662", "#FFF5D1", "#7E1037", self.Travessias)
        
        sair_button = tk.Button(self.root, text="Sair", font=self.font, fg="#CD4662", bg="#FFF5D1", highlightcolor="#7E1037", command=self.root.quit)
        sair_button.place(relx=0.05, rely=0.89)  # Posicionar o botão no canto inferior esquerdo

    # Executar o aplicativo
    def run(self):
        self.telaInicial()
        self.root.mainloop()

# Para executar o aplicativo
app = BSTApp()
app.run()