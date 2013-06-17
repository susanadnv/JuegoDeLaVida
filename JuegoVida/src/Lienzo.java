
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;



@SuppressWarnings("serial")
public class Lienzo extends JPanel implements MouseListener {

	EspacioCel espacio; 
	
	public Lienzo(){
		setPreferredSize(new Dimension(800,400));
		addMouseListener(this);
		setVisible(true);
		espacio = new EspacioCel();
	}
	
	public void paintComponent(Graphics g){

		for(int i=0; i<40; i++){
			for(int j=0; j<80; j++){
				
				if(espacio.getCelula(i,j).getEstado()==Estado.EMBRION)
					//g.setColor(new Color(48,121,216));	
					g.setColor(new Color(180,205,240));
				else if(espacio.getCelula(i,j).getEstado()==Estado.VIVA)
					g.setColor(new Color(45,115,220));
				else if(espacio.getCelula(i,j).getEstado()==Estado.MORIBUNDA)
					g.setColor(new Color(20,75,140));
				else
					g.setColor(new Color(10,30,60));
			
				g.fillRect(j*10, i*10, 10, 10);	
				g.setColor(Color.gray);
				g.fillRect(j*10, i*10, getWidth(), 1);
				g.fillRect(j*10, i*10, 1, getHeight());
			
			}
		}	
	}
	public EspacioCel getEspacioCel(){ 
		return espacio;
		}
	
	public void mouseClicked(MouseEvent arg0) {}

	public void mouseEntered(MouseEvent arg0) {}

	public void mouseExited(MouseEvent arg0) {}
	
	public void mousePressed(MouseEvent e) {
		espacio.setVivaMuerta(Math.abs(e.getY()/10), Math.abs(e.getX()/10));
		repaint();
	}

	
	public void mouseReleased(MouseEvent arg0) {}

	
	
	
	
}
