public abstract class World {
   // variables related to the world
   private int sizeX, sizeY;
   private Creature[][] cells;             // 2D array to represent the world
   private final char empty = '-';     // empty cell representation
   // variables related to the world's inhabitants
   private int population;                 // number of creatures in the world

   // constructor
   public World(int sizeX, int sizeY) {
      this.sizeX = sizeX;
      this.sizeY = sizeY;
      cells = new Creature[sizeX][sizeY];
      //initialise population at 0
      population = 0;
      this.startWorld();
   }

   /**
    * Force concrete instantions of a world to validate which cells are
    * appropriate for a creature for a creature to re-produce in (will be
    * different for each instantions)
    * @param Creature parent Creature that is re-producing
    * @param int      xPos   xPos of where the creture is attempting to reproduce
    * @param int      yPos   yPos of where the creture is attempting to reproduce
    */
   public abstract void validateReproduction(Creature parent, int xPos, int yPos);

   /**
   *  Method to initialise the world with inhabitants from both species.
   */
   private void startWorld() {
      // number of species 1 creatures to create
      int species1pop = 1;
      // number of species 2 creatures to create
      int species2pop = 1;

      // create each member of the population at a random cell in the world
      this.generateSpecies1(species1pop);
      this.generateSpecies2(species2pop);

      // start all threads
      this.startLiving();
   }

   /**
   *  Method for creating an entire new generation of species 1 creatures
   * @param int species1pop number of creatures to create.
   */
   private void generateSpecies1(int species1pop) {
      for (int i=0; i<species1pop; i++) {
         // internal infinite loop until the program generates
         // an unpopulated cell co-ordinate.
         for(;;) {
            // generate random X and Y co-ordinates
            int randX = (int) (Math.random() * sizeX);
            int randY = (int) (Math.random() * sizeY);
            if (cells[randX][randY] == null) {
               cells[randX][randY] = new Species1(this, randX, randY);
               break;
            }
         }
      }
   }

   /**
   *  Method for creating an entire new generation of species 2 creatures
   * @param int species2pop number of creatures to create.
   */
   private void generateSpecies2(int species2pop) {
      for (int i=0; i<species2pop; i++) {
         // internal infinite loop until the program generates
         // an unpopulated cell co-ordinate.
         for(;;) {
            // generate random X and Y co-ordinates
            int randX = (int) (Math.random() * sizeX);
            int randY = (int) (Math.random() * sizeY);
            if (cells[randX][randY] == null) {
               cells[randX][randY] = new Species2(this, randX, randY);
               break;
            }
         }
      }
   }

   /**
    *  Method to initiate life in all species currently in the world
    */
   private void startLiving() {
      // cycle thru both X and Y dimensions of a grid
      for (int iY=0; iY<sizeY; iY++) {
         for (int iX=0; iX<sizeX; iX++) {
            if (cells[iX][iY] != null) {
               cells[iX][iY].start();
            }
         }
      }
   }


   /**
   * Method to create a new creature of type speciesIdentifier
   * @param int x x-position of new creature
   * @param int y y-position of new creature
   */
   public synchronized void newCreature(int speciesIdentifier, int x, int y) {
      if (speciesIdentifier == 1) {
         // initialise new life at cell (x, y)
         cells[x][y] = new Species1(this, x, y);
         cells[x][y].start();

      } else if (speciesIdentifier == 2){

         // initialise new life at cell (x, y)
         cells[x][y] = new Species2(this, x, y);
         cells[x][y].start();
      } else {
         System.err.println("Species " + speciesIdentifier + " not defined!");
      }
   }

   /**
   *  Method that will remove a creature from the world at given co-ordinates.
   *  Use when a creature reaches the end of their natural lifespan, or they
   *  get murdered.
   * @param int x X co-ordinate of creature to kill
   * @param int y X co-ordinate of creature to kill
   */
   public synchronized void killCreature(int x, int y) {
      cells[x][y] = null;
   }

   /**
    * Method that marks a creature as specifically murdered
    * @param int x xPos of creature that is being murdered
    * @param int y yPos of creature that is being murdered
    */
   public synchronized void markCreatureAsMurdered(int x, int y) {
      cells[x][y].interrupt();
   }

   /**
   *  print world to the console
   */
   public synchronized void printWorld() {
      population = 0;
      // cycle thru both X and Y dimensions of a grid
      for (int iY=0; iY<sizeY; iY++) {
         for (int iX=0; iX<sizeX; iX++) {
            // REFACTOR THIS ONCE WE KNOW ABOUT THE CREATURES X AND Y
            if (cells[iX][iY] == null) {
               System.out.print(String.format(" %c", empty));
            } else {
               // make use of Creature's "toString" method to get either 1 or 2
               System.out.print(cells[iX][iY]);
               population++;
            }
         }
         System.out.println();
      }
      // print number of inhabitants in the world
      System.out.println(String.format("Total Population: %d\n", population));
   }


   /**
   * Method to return the fitness of a creature stored at position (x,y)
   * Used to determine whether a creature is murder-able
   * @param  int x             X co-ordinate of creature to check fitness of
   * @param  int y             Y co-ordinate of creature to check fitness of
   * @return     Fitness of creature at position (x, y), or -1 if no creature
   */
   public synchronized double returnFitnessAtCell(int x, int y) {
      // check that the cell we're trying to produce to is within world's borders
      boolean validX = (x >= 0) && (x < sizeX);
      boolean validY = (y >= 0) && (y < sizeY);
      if (validX && validY) {
         // check if there is a creature at position (x, y)
         if (cells[x][y] == null) {
            return -1.0;
            // if there is a creature at position (x, y), access & return its fitness
         } else {
            double fitness = cells[x][y].getFitness();
            return fitness;
         }
      } else {
         // return nonsense value if (x, y) is out of the world's boundaries.
         return -2.0;
      }
   }
}
