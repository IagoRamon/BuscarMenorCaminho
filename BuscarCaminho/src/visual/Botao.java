package visual;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import org.omg.CORBA.ARG_OUT;

import java.awt.Font;

public class Botao extends JButton{
	private int pX, pY, valor; //valor assim como o parede, indica se é uma parede, porem valor é mais usado na parte grafica
	private static boolean edit = true; // indica se pode editar a tabela ou não
	@SuppressWarnings("unused")
	private static Botao Inicio, Fim; //valores dos items iniciais e finais da busca
	private Botao pai;
	private int F,G,H;
	private boolean parede;
	
	public Botao(int pX, int pY) {
		super(Integer.toString(21 * pX + pY + 1)); // setando o numero que aparece no botão
		setFont(new Font("Tahoma", Font.PLAIN, 8));
		this.pX = pX;
		this.pY = pY;
		this.valor = 0;
		setBackground(Color.YELLOW);
		addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (arg0.getButton() == arg0.BUTTON1 && arg0.getClickCount() == 2 && !arg0.isConsumed()) //click direito duplo
					setInicio();
				else if (arg0.getButton() == arg0.BUTTON1 ) //click direito
					trocarCor();
				else if (arg0.getButton() == arg0.BUTTON3) //click direito
					setFinal();
				//System.out.println(arg0.getButton() + "");
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		setEdit(false);
		setVisible(true);
	}

	
	public Botao getInicio() {
		return Inicio;
	}

	public static void setInicio(Botao inicio) {
		Inicio = inicio;
	}

	public static Botao getFim() {
		return Fim;
	}

	public static void setFim(Botao fim) {
		Fim = fim;
	}
	
	public static Botao getIni(){
		return Inicio;
	}

	public Botao getPai() {
		return pai;
	}

	public void setPai(Botao pai) {
		this.pai = pai;
	}

	public int getF() {
		return F;
	}

	public void setF() {
		F = G + H;
	}

	public int getG() {
		return G;
	}

	public void setG(int g) {
		G = g;
	}

	public int getH() {
		return H;
	}

	public void setH() {
		int d1, d2;
		d1 = getFim().getY() - pY;
		d2 = getFim().getX() - pX;
		if (d1 < 0)
			d1 *= -1;
		if (d2 < 0)
			d2 *= -1;
		H = d1 + d2;
	}
	
	public boolean isFim(){
		if (valor == Fim.getValor())
			return true;
		else
			return false;
	}
	
	public boolean isInicio(){
		if (valor == Inicio.getValor())
			return true;
		else
			return false;
	}

	public boolean isParede() {
		return parede;
	}

	public void setParede(boolean parede) {
		this.parede = parede;
	}

		
	public int getpX() {
		return pX;
	}

	public void setpX(int pX) {
		this.pX = pX;
	}

	public int getpY() {
		return pY;
	}

	public void setpY(int pY) {
		this.pY = pY;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
	
	public void trocarCor(){ //troca a cor para amarelo ou azul
		if (canEdit()) {
			if (valor == 0)
				valor = 1;
			else
				valor = 0;
			
			if (this.valor == 0){
				parede = false;
				setBackground(Color.YELLOW);
				setForeground(Color.BLACK);
			}
			else{
				parede = true;
				setBackground(Color.BLUE);
				setForeground(Color.WHITE);
			}
		}
		if (isFim())
			Botao.setFim(null);
		if (isInicio())
			Botao.setInicio(null);
	}
	
	public void setCor(int novoValor){ 
		valor = novoValor;
		parede = false;
		if (valor == 0){ //caminho
			setBackground(Color.YELLOW);
			setForeground(Color.BLACK);
		}
		else if (valor == 1){ //parede
			setBackground(Color.BLUE);
			setForeground(Color.WHITE);
			parede = true;
		}
		else if (valor == 2){ //inicio
			setBackground(Color.GREEN);
			setForeground(Color.BLACK);
		} else if (valor == 3){ //final
			setBackground(Color.RED);
			setForeground(Color.BLACK);
		} else if (valor == 4){//caminho resultado
			setBackground(Color.WHITE);
			setForeground(Color.BLACK);
		}
	}
	
	private void setInicio(){
		if (getFim() != null && isFim())
			Botao.setFim(null);			
		if (Inicio != null)
			Inicio.setCor(0);
		Inicio = this;
		setCor(2);
	}
	
	private void setFinal(){
		if (getIni() != null && isInicio())
			Botao.setInicio(null);
		if (Fim != null)
			Fim.setCor(0);
		Fim = this;
		setCor(3);
	}
	
	public static boolean canEdit(){
		return edit;
	}
	
	public static void setEdit(boolean valor){
		edit = valor;
	}
	
	public static boolean temIniFim(){
		if (Inicio != null && Fim != null)
			return true;
		else
			return false;
	}
	
}
