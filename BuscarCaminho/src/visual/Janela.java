package visual;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controle.AStar;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Janela extends JFrame{
	private static final long serialVersionUID = 1L;
	private int linhas,colunas;
	private ArrayList <Botao> Botoes;
	private boolean resetado = true;
	
	public Janela() {
		JPanel PainelEsquerdo;
		JButton btnComecar;
		JButton btnEditarSalvar;
		JButton btnLimpar;
		JPanel tabela;
		setSize(1024, 768);
		JButton btnResetar;
		setLocationRelativeTo(null);
		
		linhas = 21;
		
		colunas = 21;
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		PainelEsquerdo = new JPanel();
		PainelEsquerdo.setMinimumSize(new Dimension(10, 80));
		PainelEsquerdo.setBackground(Color.LIGHT_GRAY);
		getContentPane().add(PainelEsquerdo, BorderLayout.NORTH);
		PainelEsquerdo.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnComecar = new JButton("Come\u00E7ar");
		btnComecar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (Botao.temIniFim() && resetado){
					AStar aStar = new AStar();
					aStar.setTabela(Botoes);
					aStar.start();
					resetado = false;
				} else if (!resetado)
					JOptionPane.showMessageDialog(null, "Antes de começar novamente, click em Resetar.");
				else
					JOptionPane.showMessageDialog(null, "Antes de começar, escolha os campos de inicio e fim.");
			}
		});
		btnComecar.setActionCommand("Comecar");
		PainelEsquerdo.add(btnComecar);
		
		btnEditarSalvar = new JButton("Editar");
		btnEditarSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (btnEditarSalvar.getText().equals("Editar")){
					Botao.setEdit(true);
					btnEditarSalvar.setText("Salvar");
				} else {
					Botao.setEdit(false);
					btnEditarSalvar.setText("Editar");
				}
			}
		});
		PainelEsquerdo.add(btnEditarSalvar);
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Botao.canEdit())
					clearTable();
			}
		});
		PainelEsquerdo.add(btnLimpar);
		
		btnResetar = new JButton("Resetar");
		btnResetar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearTable();
				if (Botao.canEdit())
					setDefaultTable();
				resetado = true;
			}
		});
		PainelEsquerdo.add(btnResetar);
		
		tabela = new JPanel();
		getContentPane().add(tabela, BorderLayout.CENTER);
		tabela.setBackground(Color.WHITE);
		tabela.setLayout(new GridLayout(linhas, colunas, 0, 0));
		
		Botoes = new ArrayList<Botao>(); 
		
		for (int i=0; i<colunas; i++)
			for (int j=0; j<linhas; j++){
				Botoes.add(new Botao(i,j));
				tabela.add(Botoes.get(Botoes.size() - 1));
			}
		setDefaultTable();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void clearTable(){ //zerando os valores dos itens da tabela
		Botao.setInicio(null);
		Botao.setFim(null);
		for (int i = 0; i < Botoes.size(); i++)
			if (Botao.canEdit() || Botoes.get(i).getValor() != 1)
				Botoes.get(i).setCor(0);
			else
				Botoes.get(i).setCor(1);	
	}
	
	public void setDefaultTable(){ //Setando a tabela padrão, index = valor do item - 1
		Botoes.get(12).setCor(1);
		Botoes.get(15).setCor(1);
		Botoes.get(16).setCor(1);
		Botoes.get(17).setCor(1);
		Botoes.get(21).setCor(1);
		Botoes.get(22).setCor(1);
		Botoes.get(24).setCor(1);
		Botoes.get(25).setCor(1);
		Botoes.get(27).setCor(1);
		Botoes.get(29).setCor(1);
		Botoes.get(30).setCor(1);
		Botoes.get(31).setCor(1);
		Botoes.get(33).setCor(1);
		Botoes.get(40).setCor(1);
		Botoes.get(42).setCor(1);
		Botoes.get(46).setCor(1);
		Botoes.get(48).setCor(1);
		Botoes.get(52).setCor(1);
		Botoes.get(54).setCor(1);
		Botoes.get(55).setCor(1);
		Botoes.get(56).setCor(1);
		Botoes.get(57).setCor(1);
		Botoes.get(59).setCor(1);
		Botoes.get(61).setCor(1);
		Botoes.get(63).setCor(1);
		Botoes.get(65).setCor(1);
		Botoes.get(66).setCor(1);
		Botoes.get(67).setCor(1);
		Botoes.get(71).setCor(1);
		Botoes.get(72).setCor(1);
		Botoes.get(73).setCor(1);
		Botoes.get(75).setCor(1);
		Botoes.get(80).setCor(1);
		Botoes.get(82).setCor(1);
		Botoes.get(84).setCor(1);
		Botoes.get(88).setCor(1);
		Botoes.get(90).setCor(1);
		Botoes.get(101).setCor(1);
		Botoes.get(103).setCor(1);
		Botoes.get(105).setCor(1);
		Botoes.get(106).setCor(1);
		Botoes.get(107).setCor(1);
		Botoes.get(111).setCor(1);
		Botoes.get(113).setCor(1);
		Botoes.get(115).setCor(1);
		Botoes.get(117).setCor(1);
		Botoes.get(118).setCor(1);
		Botoes.get(119).setCor(1);
		Botoes.get(120).setCor(1);
		Botoes.get(122).setCor(1);
		Botoes.get(138).setCor(1);
		Botoes.get(147).setCor(1);
		Botoes.get(149).setCor(1);
		Botoes.get(151).setCor(1);
		Botoes.get(152).setCor(1);
		Botoes.get(153).setCor(1);
		Botoes.get(155).setCor(1);
		Botoes.get(156).setCor(1);
		Botoes.get(157).setCor(1);
		Botoes.get(159).setCor(1);
		Botoes.get(161).setCor(1);
		Botoes.get(162).setCor(1);
		Botoes.get(164).setCor(1);
		Botoes.get(165).setCor(1);
		Botoes.get(166).setCor(1);
		Botoes.get(203).setCor(1);
		Botoes.get(204).setCor(1);
		Botoes.get(210).setCor(1);
		Botoes.get(212).setCor(1);
		Botoes.get(214).setCor(1);
		Botoes.get(216).setCor(1);
		Botoes.get(217).setCor(1);
		Botoes.get(218).setCor(1);
		Botoes.get(220).setCor(1);
		Botoes.get(223).setCor(1);
		Botoes.get(226).setCor(1);
		Botoes.get(228).setCor(1);
		Botoes.get(229).setCor(1);
		Botoes.get(230).setCor(1);
		Botoes.get(231).setCor(1);
		Botoes.get(252).setCor(1);
		Botoes.get(233).setCor(1);
		Botoes.get(254).setCor(1);
		Botoes.get(255).setCor(1);
		Botoes.get(235).setCor(1);
		Botoes.get(256).setCor(1);
		Botoes.get(237).setCor(1);
		Botoes.get(238).setCor(1);
		Botoes.get(239).setCor(1);
		Botoes.get(258).setCor(1);
		Botoes.get(259).setCor(1);
		Botoes.get(260).setCor(1);
		Botoes.get(241).setCor(1);
		Botoes.get(262).setCor(1);
		Botoes.get(283).setCor(1);
		Botoes.get(284).setCor(1);
		Botoes.get(285).setCor(1);
		Botoes.get(286).setCor(1);
		Botoes.get(223).setCor(1);
		Botoes.get(244).setCor(1);
		Botoes.get(265).setCor(1);
		Botoes.get(226).setCor(1);
		Botoes.get(247).setCor(1);
		Botoes.get(268).setCor(1);
		Botoes.get(289).setCor(1);
		Botoes.get(228).setCor(1);
		Botoes.get(229).setCor(1);
		Botoes.get(230).setCor(1);
		Botoes.get(251).setCor(1);
		Botoes.get(270).setCor(1);
		Botoes.get(272).setCor(1);
		Botoes.get(291).setCor(1);
		Botoes.get(293).setCor(1);
		Botoes.get(295).setCor(1);
		Botoes.get(316).setCor(1);
		Botoes.get(337).setCor(1);
		Botoes.get(339).setCor(1);
		Botoes.get(340).setCor(1);
		Botoes.get(341).setCor(1);
		Botoes.get(343).setCor(1);
		Botoes.get(344).setCor(1);
		Botoes.get(345).setCor(1);
		Botoes.get(346).setCor(1);
		Botoes.get(304).setCor(1);
		Botoes.get(325).setCor(1);
		Botoes.get(349).setCor(1);
		Botoes.get(350).setCor(1);
		Botoes.get(351).setCor(1);
		Botoes.get(310).setCor(1);
		Botoes.get(353).setCor(1);
		Botoes.get(312).setCor(1);
		Botoes.get(354).setCor(1);
		Botoes.get(355).setCor(1);
		Botoes.get(356).setCor(1);
		Botoes.get(314).setCor(1);
		Botoes.get(335).setCor(1);
		Botoes.get(379).setCor(1);
		Botoes.get(380).setCor(1);
		Botoes.get(381).setCor(1);
		Botoes.get(382).setCor(1);
		Botoes.get(422).setCor(1);
		Botoes.get(423).setCor(1);
		Botoes.get(424).setCor(1);
		Botoes.get(425).setCor(1);
		Botoes.get(361).setCor(1);
		Botoes.get(385).setCor(1);
		Botoes.get(386).setCor(1);
		Botoes.get(406).setCor(1);
		Botoes.get(427).setCor(1);
		Botoes.get(388).setCor(1);
		Botoes.get(389).setCor(1);
		Botoes.get(390).setCor(1);
		Botoes.get(409).setCor(1);
		Botoes.get(411).setCor(1);
		Botoes.get(432).setCor(1);
		Botoes.get(393).setCor(1);
		Botoes.get(394).setCor(1);
		Botoes.get(414).setCor(1);
		Botoes.get(415).setCor(1);
		Botoes.get(396).setCor(1);
		Botoes.get(397).setCor(1);
		Botoes.get(417).setCor(1);
		Botoes.get(418).setCor(1);
		Botoes.get(168).setCor(1);
		Botoes.get(169).setCor(1);
		Botoes.get(170).setCor(1);
		Botoes.get(172).setCor(1);
		Botoes.get(173).setCor(1);
		Botoes.get(174).setCor(1);
		Botoes.get(176).setCor(1);
		Botoes.get(177).setCor(1);
		Botoes.get(178).setCor(1);
		Botoes.get(180).setCor(1);
		Botoes.get(182).setCor(1);
		Botoes.get(183).setCor(1);
		Botoes.get(185).setCor(1);
		Botoes.get(186).setCor(1);
		Botoes.get(187).setCor(1);
	}
}
