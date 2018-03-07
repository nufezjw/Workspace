public class Species2 extends Creature {
   private final int speciesIdentifier = 2;
   private static final int maxLifespan = 5;
   private static final double fitness = 0.4;
   private final String representation = "o";

   /**
    *  Constructor for Species2-type creature
    *  @param  int xPos          X position of creature in world
    *  @param  int yPos          Y position of creature in world
    */
   public Species2(World world, int xPos, int yPos){
      super(maxLifespan, fitness, world, xPos, yPos);
   }

   /**
    *  Returns '2' to indicate this creature is of type Species 2
    * @return int speciesIdentifier
    */
   public int getSpeciesIdentifier() {
      return speciesIdentifier;
   }

   /**
    *  Override java's toString() method to get String signifier that is is
    *  a species 2 creature (as opposed to species 1)
    * @return String indicating it is a species 2 creature
    */
   public String toString() {
      return String.format(" %s", representation);
   }

}
