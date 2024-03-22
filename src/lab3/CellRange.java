package lab3;

public class CellRange {

    private Cell[] cells; // Tabloul de celule din selecție
    private int startX; // Coordonata X de start a selecției
    private int startY; // Coordonata Y de start a selecției
    private int endX; // Coordonata X de sfârșit a selecției
    private int endY; // Coordonata Y de sfârșit a selecției

    // Constructor pentru a inițializa un interval 1x1
    public CellRange(Cell cell) {
        this.cells = new Cell[]{cell};
        this.startX = cell.row;
        this.startY = cell.column;
        this.endX = cell.row;
        this.endY = cell.column;
    }

    // Constructor pentru a inițializa un interval cu coordonate
    public CellRange(Cell[] cells, int startX, int startY, int endX, int endY) {
        this.cells = cells;
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
    }

    // Metoda pentru a calcula suma celulelor din interval
    public double getSum() {
        double sum = 0.0;
        for (Cell cell : cells) {
            sum += Double.parseDouble(cell.value);
        }
        return sum;
    }

    // Metoda pentru a calcula produsul celulelor din interval
    public double getProduct() {
        double product = 1.0;
        for (Cell cell : cells) {
            product *= Double.parseDouble(cell.value);
        }
        return product;
    }
}