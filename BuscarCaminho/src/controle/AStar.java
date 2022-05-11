package controle;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import visual.Botao;

public class AStar {
	ArrayList <Botao> Abertos;
	ArrayList <Botao> Fechados;
	int Dim = 21;
	Botao [][] Tabela = new Botao [Dim][Dim];
	Botao Inicio, Fim;
	
	public void setTabela(ArrayList <Botao> Botoes){ //pegar a lista de botoes e passando para uma matriz
		for (int i = 0; i < Dim; i++)
			for (int j = 0; j < Dim; j++){
				Tabela [i][j] = Botoes.get(i * Dim + j);
				Tabela [i][j].setPai(null);
				Tabela [i][j].setG(0);
				Tabela [i][j].setH();
				Tabela [i][j].setpX(i);
				Tabela [i][j].setpY(j);
			}
		//pegando o inicio e o final da matriz
		Inicio = Botoes.get(0).getInicio();
		Fim = Botoes.get(0).getFim();
	}
	
	public void start(){
		Abertos = new ArrayList<Botao>();
		Fechados = new ArrayList<Botao>();
		Abertos.add(Inicio);
		if (buscar())
			tracarCaminho(); //funcao para pintar o caminho quando achar
		else
			JOptionPane.showMessageDialog(null,"Caminho não encontrado.");
	}
	
	public void tracarCaminho(){
		Botao.setFim(Botao.getFim().getPai());
		while (Botao.getFim() != null){
			Botao.getFim().setCor(4);
			Botao.setFim(Botao.getFim().getPai());
		}
		Botao.getIni().setCor(2);
	}
	
	public boolean buscar(){
		Botao Atual = getAtual();
		int x = 0,y = 0;
		
		if (Atual.isFim())
			return true;
		
		if (Atual != null){
			x = Atual.getpX();
			y = Atual.getpY();
		}
		
		//vizinho esquerdo
		if (y - 1 >= 0 && !Tabela[x][y-1].isParede() && !isFechado(Tabela[x][y-1].getText())){
			tratarVizinho(Tabela[x][y-1], Atual, 10);
		}
		//vizinho vizinho direito
		if (y + 1 < Dim && !Tabela[x][y+1].isParede() && !isFechado(Tabela[x][y+1].getText())){
			tratarVizinho(Tabela[x][y+1], Atual, 10);
		}
		
		if (x - 1 >= 0){ //vizinhos de cima
 			if (!Tabela[x-1][y].isParede() && !isFechado(Tabela[x-1][y].getText())) //verifica se o valor esta na lista de fechados ou se é uma parede
				tratarVizinho(Tabela[x-1][y], Atual, 10);
			if (y - 1 >= 0 && !isFechado(Tabela[x-1][y-1].getText()) && !Tabela[x-1][y-1].isParede() 
				&& !Tabela[x-1][y].isParede() && !Tabela[x][y-1].isParede()) //no caso da diagonal, verifica também a condição de poder mover para diagonal
				tratarVizinho(Tabela[x-1][y-1], Atual, 14);
			if (y + 1 < Dim && !isFechado(Tabela[x-1][y+1].getText()) && !Tabela[x-1][y+1].isParede() 
					&& !Tabela[x-1][y].isParede() && !Tabela[x][y+1].isParede())
					tratarVizinho(Tabela[x-1][y+1], Atual, 14);
		}
		if (x + 1 < Dim){ //vizinhos de baixo
			if (!Tabela[x+1][y].isParede() && !isFechado(Tabela[x+1][y].getText()))
				tratarVizinho(Tabela[x+1][y], Atual, 10);
			if (y - 1 >= 0 && !isFechado(Tabela[x+1][y-1].getText()) && !Tabela[x+1][y-1].isParede() 
				&& !Tabela[x+1][y].isParede() && !Tabela[x][y-1].isParede())
				tratarVizinho(Tabela[x+1][y-1], Atual, 14);
			if (y + 1 < Dim && !isFechado(Tabela[x+1][y+1].getText()) && !Tabela[x+1][y+1].isParede() 
					&& !Tabela[x+1][y].isParede() && !Tabela[x][y+1].isParede())
					tratarVizinho(Tabela[x+1][y+1], Atual, 14);
		}
		
		
		if (Abertos.size() == 0) //quando não há caminho, nesse caso demora muito, pois o programa praticamente tenta todas as possibilidades
			return false;
		else
			return buscar();
	}
	
	public void tratarVizinho(Botao vizinho, Botao Atual, int custo){ //funcao que faz o tratamento de cada vizinho
		if (! isAberto(vizinho.getText())){
			vizinho.setPai(Atual);
			vizinho.setG(Atual.getG() + custo);
			vizinho.setF();
			Abertos.add(vizinho);
		} else if (Atual.getG() + custo < vizinho.getG()){
			vizinho.setPai(Atual);
			vizinho.setG(Atual.getG() + custo);
			vizinho.setF();
		}
	}
	
	public Botao getAtual(){
		Botao Atual = null;
		int idxAtual = 0;
		Atual = Abertos.get(0);
		for (int i=0; i<Abertos.size(); i++){
			if (Atual.getF() > Abertos.get(i).getF()){
				Atual = Abertos.get(i);
				idxAtual = i;
			}
		}
		Abertos.remove(idxAtual);
		Fechados.add(Atual);
		return Atual;
	}
	
	public Botao getMenorF(){
		Botao btn = null;
		btn = Abertos.get(0);
		for (int i=0; i<Abertos.size(); i++)
			if (btn.getF() >= Abertos.get(i).getF())
				btn = Abertos.get(i);
		return btn;
	}
	
	public boolean isAberto(String text){
		boolean result = false;
		for (int i=0; i<Abertos.size(); i++)
			if (Abertos.get(i).getText().equals(text))
				result = true;
		return result;
	}
	
	public boolean isFechado(String text){
		boolean result = false;
		for (int i=0; i<Fechados.size(); i++)
			if (Fechados.get(i).getText().equals(text))
				result = true;
		return result;
	}
}
