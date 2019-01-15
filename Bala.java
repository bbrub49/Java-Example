package semester;

import java.util.Iterator;

public class Bala extends Ant{
	int balaID = 0;
	int lifeSpan = 0;
	boolean isDead;
	
	/**
	 * CONSTRUCTORS
	 */
	public Bala(){}
	public Bala(int ident, int health, int row, int column){
		this.setBalaID(ident);
		this.setBalaLife(health);
		this.setNodeID(row, column);
	}
	
	/**
	 * GET & SET
	 */
	public void setBalaID(int id){
		balaID = id;
	}
	public int getBalaID(){
		return balaID;
	}
	
	public void setBalaLife(int health){
		lifeSpan = health;
	}
	public int getBalaLife(){
		return lifeSpan;
	}
	
	/**
	 * METHODS
	 */
	public void move(){
		int ranMove = Simulation.getRanNum(1,8);
		Node temp = new Node();
		if((this.getRowID() == 0 && this.getColID() != 0) && (this.getRowID() == 0 && this.getColID() != Colony.width-1)){
			while(ranMove == 1 || ranMove == 5 || ranMove == 8){
				ranMove = Simulation.getRanNum(1,8);
			}
			temp = this.whereToMove(ranMove);
		}
		else if((this.getRowID() == Colony.height-1 && this.getColID() != 0) && (this.getRowID() == Colony.height-1 && this.getColID() != Colony.width-1)){
			while(ranMove == 3 || ranMove == 6 || ranMove == 7){
				ranMove = Simulation.getRanNum(1,8);
			}
			temp = this.whereToMove(ranMove);
		}
		else if((this.getColID() == Colony.width-1 && this.getRowID() != 0) && (this.getColID() == Colony.width-1 && this.getRowID() != Colony.height-1)){
			while(ranMove == 2 || ranMove == 5 || ranMove == 6){
				ranMove = Simulation.getRanNum(1,8);
			}
			temp = this.whereToMove(ranMove);
		}
		else if((this.getColID() == 0 && this.getRowID() != 0) && (this.getColID() == 0 && this.getRowID() != Colony.height-1)){
			while(ranMove == 4 || ranMove == 7 || ranMove == 8){
				ranMove = Simulation.getRanNum(1,8);
			}
			temp = this.whereToMove(ranMove);
		}
		else if(this.getRowID() == 0 && this.getColID() == 0){
			while(ranMove == 1 || ranMove == 4 || ranMove == 5 || ranMove == 7 || ranMove == 8){
				ranMove = Simulation.getRanNum(1,8);
			}
			temp = this.whereToMove(ranMove);
		}
		else if(this.getRowID() == 0 && this.getColID() == Colony.width-1){
			while(ranMove == 1 || ranMove == 2 || ranMove == 5 || ranMove == 6 || ranMove == 8){
				ranMove = Simulation.getRanNum(1,8);
			}
			temp = this.whereToMove(ranMove);
		}
		else if(this.getRowID() == Colony.height-1 && this.getColID() == 0){
			while(ranMove == 3 || ranMove == 4 || ranMove == 6 || ranMove == 7 || ranMove == 8){
				ranMove = Simulation.getRanNum(1,8);
			}
			temp = this.whereToMove(ranMove);
		}
		else if(this.getRowID() == Colony.height-1 && this.getColID() == Colony.width-1){
			while(ranMove == 2 || ranMove == 3 || ranMove == 5 || ranMove == 6 || ranMove == 7){
				ranMove = Simulation.getRanNum(1,8);
			}
			temp = this.whereToMove(ranMove);
		}
		else{
			temp = this.whereToMove(ranMove);
		}
		
		Colony.colNode[this.getRowID()][this.getColID()].removeAnt(this);
		Colony.colNode[temp.getNodeRow()][temp.getNodeCol()].addAnt(this);
		
		if(checkNode(temp) == true){
			this.attack();
		}
	}
	
	public void attack(){
		int accuracy = Simulation.getRanNum(0,100);
		if(accuracy >= 51){
			for(Iterator<Ant> i = Colony.colNode[this.getRowID()][this.getColID()].nodeAntList.iterator(); i.hasNext();){
				Ant a = i.next();
				if(!(a instanceof Bala)){
					a.death(a);
					break;
				}
			}
		}
	}
	
	public boolean checkNode(Node n){
		if(n.nodeAntList.size() > 1){
			return true;
		}
		else{
			return false;
		}
	}
	
	
	
	
}
