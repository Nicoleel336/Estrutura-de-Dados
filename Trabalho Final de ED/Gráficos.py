import matplotlib.pyplot as plt
import numpy as np

def plot_TempoInclusao(Data_Structs, Insertion_Time):
    """Plotar o gráfico de tempo de inserção."""
    x = np.arange(len(Data_Structs))
    width = 0.35
    fig, ax = plt.subplots()
    bars = ax.bar(x, Insertion_Time, width, label='Tempo de Inserção', color='#FFC567')
    for i, bar in enumerate(bars):
        height = bar.get_height()
        ax.annotate('{}'.format(height),
                    xy=(bar.get_x() + bar.get_width() / 2, height),
                    xytext=(0, 3),
                    textcoords="offset points",
                    ha='center', va='bottom')
    ax.set_ylabel('Tempo de Inserção (ns)', color='#552cb7')
    plt.grid(axis='y', linestyle='--', alpha=0.7)
    ax.set_title('Tempo de Inserção de 140.000 Palavras por Estrutura de Dados', color='#552cb7')
    ax.set_xticks(x)
    ax.set_xticklabels(Data_Structs, rotation=45, ha='right')
    ax.legend()
    plt.tight_layout()
    plt.show()

def plot_TempoConsulta(Data_Structs, tempos_medios):
    """Plotar o gráfico de tempo médio de consulta"""
    x = np.arange(len(Data_Structs))
    width = 0.5
    plt.figure(figsize=(10, 6))
    bars = plt.bar(x, tempos_medios, width, color='#FD5A46')
    for i, bar in enumerate(bars):
        height = bar.get_height()
        plt.text(bar.get_x() + bar.get_width() / 2, height, '%d' % int(height), ha='center', va='bottom')
    plt.xlabel('Estruturas de Dados', color='#552cb7')
    plt.ylabel('Tempo Médio de Consulta (ns)', color='#552cb7')
    plt.title('Tempo Médio de Execução das 10 Consultas por Estrutura de Dados', color='#552cb7')
    plt.xticks(x, Data_Structs, rotation=45, ha='right')
    plt.grid(axis='y', linestyle='--', alpha=0.7)
    plt.tight_layout()
    plt.show()

def plot_TempoRemocao(Data_Structs, tempos_medios_remocao):
    """Plotar o gráfico de tempo médio de remoção"""
    x = np.arange(len(Data_Structs))
    width = 0.5
    plt.figure(figsize=(10, 6))
    bars = plt.bar(x, tempos_medios_remocao, width, color='#FB7DA8')
    for i, bar in enumerate(bars):
        height = bar.get_height()
        plt.text(bar.get_x() + bar.get_width() / 2, height, '%d' % int(height), ha='center', va='bottom')
    plt.xlabel('Estruturas de Dados', color='#552cb7')
    plt.ylabel('Tempo Médio de Remoção (ns)', color='#552cb7')
    plt.title('Tempo Médio de Execução das 10 Exclusões por Estrutura de Dados', color='#552cb7')
    plt.xticks(x, Data_Structs, rotation=45, ha='right')
    plt.grid(axis='y', linestyle='--', alpha=0.7)
    plt.tight_layout()
    plt.show()

if __name__ == "__main__":
    # Gráfico de Inserção
    Data_Structs = ['Vector', 'LinkedList', 'ArrayList', 'HashSet', 'LinkedHashSet', 'TreeSet', 'HashMap', 'LinkedHashMap', 'TreeMap']
    Insertion_Time = [32877380, 82654660, 216606720, 116375240, 84020700, 343942440, 76944620, 80980320, 343107260]
    plot_TempoInclusao(Data_Structs, Insertion_Time)

    # Gráfico de Consulta
    tempos_medios_consulta = [3333674.0, 5014931.2, 3959774.0, 4642.0 , 2056.0, 6220.2, 1766.0, 1666.0, 5194.0]
    plot_TempoConsulta(Data_Structs, tempos_medios_consulta)

    # Gráfico de Remoção
    tempos_medios_remocao = [3510776.0, 5125594.0, 3976874.2, 4320.2, 3374.0, 8073.2, 2426.4, 3020.8, 6028.0]
    plot_TempoRemocao(Data_Structs, tempos_medios_remocao)