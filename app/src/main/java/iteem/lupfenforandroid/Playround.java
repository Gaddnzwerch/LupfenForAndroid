package iteem.lupfenforandroid;

import java.util.Vector;
import java.util.Iterator;

public class Playround extends Vector<Player>{
   int currentPlayer;
   int starting;
   int lastIndex;
   
   public Playround() {
       super();
       this.currentPlayer = 0;
       this.lastIndex = 0;
   }
   public void lastPlayer(Player aPlayer) {
       this.lastIndex = this.indexOf(aPlayer);
   }
   public void firstPlayer(Player aPlayer) {
       int index = this.indexOf(aPlayer) - 1;
       if(index<0) {
           index = this.size()-1;
       } 
       this.lastIndex = index;
   }
   public Boolean hasPlayer(Player aPlayer) {
        return (this.indexOf(aPlayer) != -1);
    }

   @Override
   public Iterator<Player> iterator() {
       return new PlayerIterator(this, this.lastIndex);
   }

   private class PlayerIterator implements Iterator<Player> {

       Playround data;
       int currentIndex;
       int lastIndex;
       Boolean started;

       public PlayerIterator(Playround aData, int aLastIndex) {
           this.data = aData;
           this.currentIndex = aLastIndex;
           this.lastIndex = aLastIndex;
           this.started = false;
       }
        
       @Override
       public boolean hasNext() {
           if (!this.started) {
               return (this.data.size() > 0);
           }
           return (this.currentIndex != this.lastIndex); 
       }
       
       @Override
       public Player next() {
           this.started = true;
           this.currentIndex = this.getNextIndex();
           return this.data.elementAt(this.currentIndex); 
       }
       
       private int getNextIndex() {
           int nextIndex = this.currentIndex + 1;
           if (nextIndex >= this.data.size()) {
               nextIndex = 0;
           }
           return nextIndex;
       }

       @Override
       public void remove() {
           throw new UnsupportedOperationException();
       } 
   }
} 
