import tkinter as tk
from tkinter import ttk
import matplotlib.pyplot as plt
import numpy as np

class GraphViewer(tk.Tk):
    def __init__(self):
        super().__init__()

        self.title("Gráficos de Tempo de Execução")
        self.geometry("400x200")

        # Muda a cor de fundo
        self.configure(background='#b79cee')

        # Muda a fonte
        self.option_add('*Font', 'Consolas')

        # Label de instrução
        self.label = ttk.Label(self, text="Escolha o tipo de gráfico:")
        self.label.pack(pady=10)

        # Combobox para selecionar o tipo de gráfico
        self.graph_type_var = tk.StringVar()
        self.graph_type_combobox = ttk.Combobox(self, textvariable=self.graph_type_var, values=["Inserção", "Consulta", "Remoção"])
        self.graph_type_combobox.pack()

        # Botão para mostrar o gráfico selecionado
        self.botao = ttk.Button(self, text="Mostrar Gráfico", command=self.show_graph)
        self.botao.pack(pady=10)

    def show_graph(self):
        # Dados para os gráficos de exemplo
        Data_Structs = ['Vector', 'LinkedList', 'ArrayList', 'HashSet', 'LinkedHashSet', 'TreeSet', 'HashMap', 'LinkedHashMap', 'TreeMap']
        tempos_medios_inclusao = [32877380, 82654660, 216606720, 116375240, 84020700, 343942440, 76944620, 80980320, 343107260]
        tempos_medios_consulta = [3333674.0, 5014931.2, 3959774.0, 4642.0 , 2056.0, 6220.2, 1766.0, 1666.0, 5194.0]
        tempos_medios_remocao = [3510776.0, 5125594.0, 3976874.2, 4320.2, 3374.0, 8073.2, 2426.4, 3020.8, 6028.0]

        selecao = self.graph_type_var.get()

        # Plotar o gráfico selecionado
        if selecao == "Inserção":
            self.plot_graph(Data_Structs, tempos_medios_inclusao, "Tempo de Inserção de 140.000 Palavras por Estrutura de Dados", "Tempo de Inserção (ns)")
        elif selecao == "Consulta":
            self.plot_graph(Data_Structs, tempos_medios_consulta, "Tempo Médio de Execução das 10 Consultas por Estrutura de Dados", "Tempo Médio de Consulta (ns)")
        elif selecao == "Remoção":
            self.plot_graph(Data_Structs, tempos_medios_remocao, "Tempo Médio de Execução das 10 Exclusões por Estrutura de Dados", "Tempo Médio de Remoção (ns)")

    def plot_graph(self, x_labels, y_values, title, ylabel):
        plt.figure(figsize=(10, 6))
        bars = plt.bar(x_labels, y_values, color='#FFC567')
        plt.xlabel('Estruturas de Dados')
        plt.ylabel(ylabel)
        plt.title(title)
        plt.xticks(rotation=45, ha='right')
        plt.grid(axis='y', linestyle='--', alpha=0.7)
        
        # Colocar os valores em cima das barras
        for bar in bars:
            yval = bar.get_height()
            plt.text(bar.get_x() + bar.get_width()/2, yval, round(yval, 2), va='bottom', ha='center', color='black')
            
        plt.tight_layout()
        plt.show()

if __name__ == "__main__":
    app = GraphViewer()
    app.mainloop()