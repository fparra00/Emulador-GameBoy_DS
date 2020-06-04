package emuladorgameboy;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.Point;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase principal SNAKE - Extiende JFRame
 *
 * @author whysxpvrrv
 */
public class Snake extends JFrame {
    
    //VARIABLES INTERNAS:

    //Instancia de reproductor
    public Reproductor player = new Reproductor();
    //Instancia dibujoSnake, clase con la que "dibujaremos" nuestro Snake
    DibujarSnake dibujoSnake;
    //Variable point con la que dibujaremos snake
    Point snake;
    //Variable point con la que representaremos la comida
    Point comida;
    //ArrayList del cuerpo de Snake
    ArrayList<Point> cuerpoSnake = new ArrayList<Point>();
    int longitud = 2;
    
    //Dimensiones de la ventana
    int anchura = 640;
    int altura = 480;
    
    //Dimensiones de Snake y de comida
    int anchuraPtos = 10;
    int alturaPtos = 10;

    //En esta variable almacenaremos la dirección de nuestro Snake, por defecto, al inicial el proyecto se moverá hacia la derecha
    String direccion = "RIGHT";
    
    //Auxiliar que utilizaremos para comprobar el refresco en cantidad de ms
    long frecuencia = 50;
    //Resultado de Snake
    int resultado = 10;
    //Booleano de fail
    boolean fail = false;

    public Snake() {
        setTitle("Snake");
    
        //Comenzamos juego
        comenzar();
        //Instanciamos método para pintar Snake, y lo añadimos a nuestro JF
        dibujoSnake = new DibujarSnake();
        this.getContentPane().add(dibujoSnake);
        //Seteamos alchura antura
        setSize(anchura, altura);
        //Agregamos un listener de eventos de tecla con nuestra clase Teclas
        this.addKeyListener(new Teclas());
        //Propiedades gráficas
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JFrame.setDefaultLookAndFeelDecorated(false);
        setUndecorated(true);
        //Gracias a toolkit obtenemos la dimensión de la pantalla en la que se ejecuta el proyecto,
        //y situamos la ventana en la mitad
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        //La hacemos visible
        setVisible(true);
        //Instanciamos clase momento e hilo, y lo ejecutamos
        calcularCoord momento = new calcularCoord();
        Thread trid = new Thread(momento);
        trid.start();

    }

    //FUNCIÓN: comenzar
    public void comenzar() {
        //Asignamos la variable comida a un point, al que, en la clase pintarComida, randomearemos las coordenada
        comida = new Point(200, 100);
        //Instanciamos snake en las coordenadas 320x240
        snake = new Point(320, 240);
        //Creamos un arrayList, e instanciamos en el el primer punto, la cabeza de Snake
        //Este arrayList contendrá el cuerpo de nuestro Snake
        cuerpoSnake = new ArrayList<Point>();
        cuerpoSnake.add(snake);
        longitud = cuerpoSnake.size();
    }

     //FUNCIÓN: pintarComida
    public void pintarComida() {
        //Random del que obtendremos las coordenadas
        Random rnd = new Random();
        //Asignamos la horizontal de comida a un random
        comida.x = (rnd.nextInt(anchura)) + 5;
        //Los valores deben ser multiplos de 5, para que la comida aparezca en la ventana, 
        //por lo que generaremos las siguientes comprobaciones.
        //EJE HORIZONTAL:
        if ((comida.x % 5) > 0) {
            comida.x = comida.x - (comida.x % 5);
        }
        if (comida.x < 5) {
            comida.x = comida.x + 10;
        }
        if (comida.x > anchura) {
            comida.x = comida.x - 10;
        }

        //EJE VERTICAL:
        comida.y = (rnd.nextInt(altura)) + 5;
        if ((comida.y % 5) > 0) {
            comida.y = comida.y - (comida.y % 5);
        }
        if (comida.y > altura) {
            comida.y = comida.y - 10;
        }
        if (comida.y < 0) {
            comida.y = comida.y + 10;
        }

    }

    //FUNCIÓN actualizar:
    public void actualizar() {
        //Agregamos en la posicion 0 un nuevo punto y eliminamos el ultimo
        cuerpoSnake.add(0, new Point(snake.x, snake.y));
        cuerpoSnake.remove(cuerpoSnake.size() - 1);

        //Para comprobar si Snake chocó contra sí mismo, recorremos el arrayList, y en cada iteracion creamos un point
        //que contendrá las posiciones horizontales y verticales actuales de Snake.
        //En caso de que coordenadas coincidan, hemos perdido.
        for (int i = 1; i < cuerpoSnake.size(); i++) {
            //Point auxiliar
            Point point = cuerpoSnake.get(i);
            if (snake.x == point.x && snake.y == point.y) {
                fail = true;
            }
        }

        //Comprobamos si Snake ha pasado por el punto de comida, comprobando si las cooredenadas horizontales y verticales son 
        //mayores o menores que las coordenadas horizontales y verticales de la comida menos 10, que es la altura y anchura de Snake
        if ((snake.x > (comida.x - 10) && snake.x < (comida.x + 10)) && (snake.y > (comida.y - 10) && snake.y < (comida.y + 10))) {
            cuerpoSnake.add(0, new Point(snake.x, snake.y));
            //En caso de comprobación correcta, llamamos al método pintarComida
            pintarComida();
        }
        //Método rePaint
        dibujoSnake.repaint();

    }

    //En el Main solo instanciamos la clase Snake
    public static void main(String[] args) {
        Snake snake1 = new Snake();
    }

    //CLASE dibujoSnake - Extiende de JPanel
    public class DibujarSnake extends JPanel {

        //Sobreescribimos el metodo paintComponent
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            //En caso de que haya acabado el juego, reproducimos sonido de GameOver
            if (fail) {
                player.play("src/sonidos/GameOver.wav");
            } else {
                //Asignamos el color de fondo verde, como el fondo del emulador
                g.setColor(new java.awt.Color(106, 128, 28));
            }
            //Delimitamos el filo de nuestro Snake, que será de 10x10
            g.fillRect(0, 0, anchura, altura);
            //Pintamos nuestro pointSnake de color negro
            g.setColor(Color.BLACK);
            
            //Comprobación del arrayList que contiene el cuerpo de Snake y comida:
            if (cuerpoSnake.size() > 0) {
                //En caso de que sea mayor que 0 (siempre)
                for (int i = 0; i < cuerpoSnake.size(); i++) {
                    //Dibujamos todos los cuadrados que este contenga
                    Point p = (Point) cuerpoSnake.get(i);
                    g.fillRect(p.x, p.y, anchuraPtos, alturaPtos);
                }
            }
            //Dibujamos:
            g.setColor(new Color(255, 0, 0));
            g.fillRect(comida.x, comida.y, anchuraPtos, alturaPtos);
            
            //En caso de acabar el juego
            if (fail) {
                try {
                    //Esperamos 1500ms, y cerramos la ventana
                    Thread.sleep(1500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Snake.class.getName()).log(Level.SEVERE, null, ex);
                }
                dispose();
            }
        }
    }

     //CLASE teclas - Extiende de keyAdapter. Listener de teclas.
    public class Teclas extends java.awt.event.KeyAdapter {

        //Sobreescribimos la clase keyPressed, con la que comprobaremos la tecla que ha sido pulsada
        public void keyPressed(KeyEvent e) {
            //En caso de que se pulse ESC, salir de la ventana
            if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                System.exit(0);
                //En caso de pulsar la flecha derecha
            } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                //Si Snake no se esta moviendo hacia la izquierda... dirección DERECHA
                if (direccion != "LEFT") {
                    direccion = "RIGHT";
                }
                //Idem derecha... dirección IZQUIERDA
            } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                if (direccion != "RIGHT") {
                    direccion = "LEFT";
                }
                //Idem abajo... dirección ARRIBA
            } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                if (direccion != "DOWN") {
                    direccion = "UP";
                }
                //Idem arriba... dirección ABAJO
            } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                if (direccion != "UP") {
                    direccion = "DOWN";
                }
                //En caso de pulsar N, el juego se reiniciará
            } else if (e.getKeyCode() == KeyEvent.VK_N) {
                fail = false;
                comenzar();
            }
        }

    }

    //CLASE calcularCoord: Extiende de Thread
    public class calcularCoord extends Thread {

        //Variable a la que asignaremos ms
        private long last = 0;

        public calcularCoord() {
        }

        //Se ejecuta en bucle
        public void run() {
            while (true) {
                //Metodo que devuelve el tiempo de ejecución de nuestro programa
                //Gracias a esta comprobación actualizaremos el tiempo cada 20ms
                if ((java.lang.System.currentTimeMillis() - last) > frecuencia) {
                    if (!fail) {
                        //DERECHA:
                        if (direccion == "RIGHT") {
                            //La posición horizontal de Snake será su posición actual más su anchura
                            snake.x = snake.x + anchuraPtos;
                            resultado = resultado + 2;
                            //En caso de que intente salir de la anchura del tablero, lo posicionamos en la coordenada 0
                            if (snake.x > anchura) {
                                snake.x = 0;
                            }
                            //IZQUIERDA:
                        } else if (direccion == "LEFT") {
                            //Idem Resta:
                            snake.x = snake.x - anchuraPtos;
                            if (snake.x < 0) {
                                snake.x = anchura - anchuraPtos;
                                resultado = resultado + 2;
                            }
                            //ARRIBA:
                        } else if (direccion == "UP") {
                            //Le restamos a la coordenada vertical de Snake su tamaño
                            snake.y = snake.y - alturaPtos;
                            //En caso de que la coordenada sea menor que 0, haremos que vaya al principio de la parte inferior del tablero
                            if (snake.y < 0) {
                                snake.y = altura;
                                resultado = resultado + 4;
                            }
                            //ABAJO:
                        } else if 
                                (direccion == "DOWN") {
                            //Le sumamos a la coordenada vertical de Snake su tamaño
                            snake.y = snake.y + alturaPtos;
                            resultado = resultado + 4;
                            //En caso de que la posicion vertical sea mayor que la altura del tablero, haremos que aparezca en la parte superior
                            if (snake.y > altura) {
                                snake.y = 0;
                            }
                        }
                    }
                    //Repintamos
                    actualizar();
                    //Asignamos los ms de ejecución de cada comprobación a la variable last
                    last = java.lang.System.currentTimeMillis();
                }
            }
        }
    }

    //GETTERS Y SETTERS DE RESULTADO
    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }
}
