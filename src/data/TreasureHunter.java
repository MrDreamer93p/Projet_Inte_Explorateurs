package data;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class TreasureHunter extends JFrame {
    private final int[][] map = {
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1},
            {1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 1},
            {1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1},
            {1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1},
            {1, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1},
            {1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1},
            {1, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1},
            {1, 0, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1},
            {1, 0, 1, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1},
            {1, 0, 0, 0, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1},
            {1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
    };

    private int heroX;
    private int heroY;
    private int treasuresFound;

    public TreasureHunter() {
        setTitle("Exemple TrésorHunter");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        placeHero();
        placeTreasures();

        new Thread(this::huntTreasures).start();
    }

    private void placeHero() {
        do {
            heroX = (int) (Math.random() * map[0].length);
            heroY = (int) (Math.random() * map.length);
        } while (map[heroY][heroX] == 1);
    }

    private void placeTreasures() {
        int numTreasures = 5;
        int treasuresPlaced = 0;
        while (treasuresPlaced < numTreasures) {
            int x = (int) (Math.random() * map[0].length);
            int y = (int) (Math.random() * map.length);
            if (map[y][x] == 0) {
                map[y][x] = 2; // 2 représente un trésor
                treasuresPlaced++;
            }
        }
    }

    private void huntTreasures() {
        while (treasuresFound < 5) {
            // Effectuer un mouvement aléatoire
            int dx, dy;
            do {
                Random random = new Random();
                dx = random.nextInt(3) - 1; // -1, 0, 1
                dy = random.nextInt(3) - 1;
            } while (!isValidMove(heroX + dx, heroY + dy));
            moveHero(dx, dy);

            try {
                Thread.sleep(500); // Ralentir le thread pour une meilleure visualisation
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Vérifier s'il y a un trésor à cette position
            if (map[heroY][heroX] == 2) {
                treasuresFound++;
                map[heroY][heroX] = 0; // Retirer le trésor de la carte
                System.out.println("Trésor trouvé! Tttal: " + treasuresFound);
            }
        }
        System.out.println("All treasures found!");
    }

    private void moveHero(int dx, int dy) {
        int newHeroX = heroX + dx;
        int newHeroY = heroY + dy;
        if (isValidMove(newHeroX, newHeroY)) {
            heroX = newHeroX;
            heroY = newHeroY;
            repaint();
        }
    }

    private boolean isValidMove(int x, int y) {
        return x >= 0 && x < map[0].length && y >= 0 && y < map.length && map[y][x] != 1;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[y].length; x++) {
                if (map[y][x] == 1) {
                    g.setColor(Color.BLACK);
                    g.fillRect(x * 20, y * 20, 20, 20);
                } else if (map[y][x] == 2) {
                    g.setColor(Color.YELLOW);
                    g.fillOval(x * 20 + 5, y * 20 + 5, 10, 10);
                }
            }
        }
        g.setColor(Color.BLUE);
        g.fillOval(heroX * 20 + 5, heroY * 20 + 5, 10, 10);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TreasureHunter treasureHunter = new TreasureHunter();
            treasureHunter.setVisible(true);
        });
    }
}
