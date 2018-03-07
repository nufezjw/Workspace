public class EdgeWorld extends World{
   private final int sizeX;
   private final int sizeY;

   // constructor
   public EdgeWorld(int sizeX, int sizeY) {
      super(sizeX, sizeY);
      this.sizeX = sizeX;
      this.sizeY = sizeY;
   }

   /**
   * World-specific method that validates which surrounding cells a creature
   * can re-produce in... for this world (EdgeWorld), simply limits
   * the re-production to cells within the world's borders and boundaries.
   * @param Creature parent Creature that is re-producting
   * @param int      x     xPos of where the creture is attempting to reproduce
   * @param int      y     yPos of where the creture is attempting to reproduce
   */
   public synchronized void validateReproduction(Creature parent, int x, int y) {
      // check that the cell we're trying to produce to is within world's borders
      boolean validX = (x >= 0) && (x < sizeX);
      boolean validY = (y >= 0) && (y < sizeY);
      if (validX && validY) {
         // ready 2 re-produce
         parent.makeChildren(x, y);
      }
   }


}
