
public abstract class Creature extends Thread {
   private final int maxLifespan;   // in seconds!
   private final int lifespan;      // in milliseconds!
   private final double fitness;    // species-specific
   private final World world;
   private final int x, y;       // x and y co-ordinates of creature in the world

   // constructor
   public Creature(int maxLifespan, double fitness, World world, int xPos, int yPos) {
      // creature specific data
      this.maxLifespan = maxLifespan;
      this.fitness = fitness;
      // create random lifespan between 0 and max lifespan of species type
      lifespan = (int) ((Math.random() * (maxLifespan*1000)) + 1);

      // data about the creature's environment
      this.world = world;
      x = xPos;
      y = yPos;
   }

   // accessors:
   public double getFitness() {
      return fitness;
   }

   /**
   * methods to return the X and Y positions of this creature
   */
   public int getXPos() { return x; }
   public int getYPos() { return y; }

   /**
    *  Forces each concrete instance of a species to be identifiable via an int
    *  identifier (ie. 1, 2, etc)
    * @return int something to specift what species a creature is
    */
   public abstract int getSpeciesIdentifier();

   /**
    * Try to live a full and happy life, but also handle getting murdered
    */
   public void run(){
      /**
      *  just trying to live
      *  the winter of our species
      *  to a ripe old age
      */
      try{
         Thread.sleep(lifespan);
         this.reproduce();
         // InterruptedException thrown if a creature is murdered
      } catch (InterruptedException e) {
         // fall thru
         // System.out.println("(" + x + ", " + y + "):  there's been a murder ðŸ‘¨ðŸ�»");
      }
   }

   /**
   *  method to determine if and how a creature should
   * @param int speciesIdentifier [description]
   */
   public void reproduce() {
      // try to reproduce in this.x, this.y and every surrounding cell
      for (int iX=-1; iX<=1; iX++) {
         for (int iY=-1; iY<=1; iY++) {
            int tryX = x + iX;
            int tryY = y + iY;

            // reproduction depends on what world a creature lives in
            world.validateReproduction(this, tryX, tryY);
         }
      }
   }


   public void makeChildren(int xPos, int yPos) {
      boolean emptyCell = world.returnFitnessAtCell(xPos, yPos) == -1.0;
      boolean parentsCell = (this.getXPos() == xPos) && (this.getYPos() == yPos);

      // case for when cell at (x, y) is empty
      if (emptyCell) {
         // factor in the chance that reproduction won't happen
         if (Math.random() <= this.getFitness()) {
            // create child in empty square
            world.newCreature(this.getSpeciesIdentifier(), xPos, yPos);
         }

         // case for when cell at (x, y) is occupied by parent
      } else if (parentsCell) {
         // clear parent's cell
         world.killCreature(xPos, yPos);

         // should it re-produce in parent's square?
         if (Math.random() <= this.getFitness()) {
            // parent gets replaced
            world.newCreature(this.getSpeciesIdentifier(), xPos, yPos);
         }

         // case for when cell at (x, y) is occupied by some other creature
      } else {
         // only reproduce if the parent is fitter than the creature
         // currently occupying the cell we're tryna re-produce to
         boolean murder = Math.random() <= this.getFitness() - world.returnFitnessAtCell(xPos, yPos);
         if(murder) {
            // murder the creature currently living at cell (xPos, yPos)
            world.markCreatureAsMurdered(xPos, yPos);
            world.killCreature(xPos, yPos);
            world.newCreature(this.getSpeciesIdentifier(), xPos, yPos);
         }
      }
   }
}
