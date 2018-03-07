public class Species1 extends Creature {
   private final int speciesIdentifier = 1;
   private static final int maxLifespan = 10;
   private static final double fitness = 0.8;
   private final String representation = "+";


   /**
    *  Constructor for Species1-type creature
    *  @param  int xPos          X position of creature in world
    *  @param  int yPos          Y position of creature in world
    */
   public Species1(World world, int xPos, int yPos){
      super(maxLifespan, fitness, world, xPos, yPos);
   }

   /**
    *  Returns '1' to indicate this creature is of type Species 1
    * @return [description]
    */
   public int getSpeciesIdentifier() {
      return speciesIdentifier;
   }

   /**
    *  Override java's toString() method to get String signifier that is is
    *  a species 1 creature (as opposed to species 2)
    * @return String indicating it is a species 2 creature
    */
   public String toString() {
      return String.format(" %s", representation);
   }
}
