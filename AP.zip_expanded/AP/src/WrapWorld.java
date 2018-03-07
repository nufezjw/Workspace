public class WrapWorld extends World{
   private final int sizeX;
   private final int sizeY;

   // constructor
   public WrapWorld(int sizeX, int sizeY) {
      super(sizeX, sizeY);
      this.sizeX = sizeX;
      this.sizeY = sizeY;
   }

   /**
   * World-specific method that validates which surrounding cells a creature
   * can re-produce in... for this world (WrapWorld), simply pushes any out-
   * of-boundary cells that are trying to be re-produced to to the opposite
   * (l-r, or top-bottom) edge of the world! 🌴
   * @param Creature parent Creature that is re-producting
   * @param int      x     xPos of where the creture is attempting to reproduce
   * @param int      y     yPos of where the creture is attempting to reproduce
   */
   public synchronized void validateReproduction(Creature parent, int x, int y) {
      // check if xPos is off the left edge of the world
      if (x == -1) {
         // wrap to right
         x = sizeX - 1;
      // check if xPos is off the right edge of the world
      } else if (x == sizeX) {
         // wrap to left
         x = 0;
      }

      // check if yPos is off the top edge of the world
      if (y == -1) {
         // wrap to bottom
         y = sizeY - 1;
      // check if yPos is off the bottom edge of the world
      } else if (y == sizeY) {
         // wrap to top
         y = 0;
      }

      // ready 2 re-produce
      parent.makeChildren(x, y);
   }
}
