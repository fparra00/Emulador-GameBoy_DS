package emuladorgameboy;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author whysxpvrrv
 */
public final class Menu_GameBoy extends javax.swing.JFrame implements ActionListener {

    //VARIABLES INTERNAS:
    //Reproductor de sonidos:
    public Reproductor player = new Reproductor();
    //Timer para las animaciones:
    public Timer timer = null;
    //String que utilizaremos para las animaciones:
    public String animBarra = "<html><body>____________</body></html>";
    //Auxiliar que utilizaremos para las animaciones
    int segundo = 0;
    //ImageIcon de un icono
    ImageIcon imageIcon = new ImageIcon(new ImageIcon("src/imagenes/icono.png").getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT));
    //Snake
    Snake s;
    //Inicials
    String iniciales;

    public Menu_GameBoy() {
        //Iniciamos Componentes
        initComponents();
        //Centramos la ventana
        setLocationRelativeTo(null);
        //Título
        setTitle("Emulador Gameboy - Proyecto Final CENEC");
        //Asignamos el fondo
        ImageIcon imagen = new ImageIcon("src/imagenes/fondo.png");
        Icon icono2 = new ImageIcon(imagen.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_DEFAULT));
        fondo.setIcon(icono2);
        //Por defecto, nuestra DS estará apagada hasta que hagamos click en el botón encender
        encender(false);
        //Lanzaremos un aviso, indicando que debemos hacer click en el botón ON.
        JOptionPane.showMessageDialog(null, "<html><body>Para encender el mulador, deberás hacer click en el botón ON!<br><br><b> Fernando </b></body></html>", "Enciéndeme!", JOptionPane.DEFAULT_OPTION, imageIcon);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonA = new javax.swing.JButton();
        botonOn = new javax.swing.JButton();
        botonOff = new javax.swing.JButton();
        botonSelect = new javax.swing.JButton();
        info = new javax.swing.JLabel();
        jIniciales = new javax.swing.JLabel();
        txtIniciales = new javax.swing.JTextField();
        separador = new javax.swing.JLabel();
        botonArriba = new javax.swing.JButton();
        botonAbajo = new javax.swing.JButton();
        botonStart = new javax.swing.JButton();
        gameboy = new javax.swing.JLabel();
        foto = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        botonA.setBorder(null);
        botonA.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonAMouseClicked(evt);
            }
        });
        botonA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                botonAKeyPressed(evt);
            }
        });
        getContentPane().add(botonA, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 500, 50, 50));

        botonOn.setBorder(null);
        botonOn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonOn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonOnMouseClicked(evt);
            }
        });
        getContentPane().add(botonOn, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 160, 20, 20));

        botonOff.setBorder(null);
        botonOff.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonOff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonOffMouseClicked(evt);
            }
        });
        getContentPane().add(botonOff, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 160, 20, 20));

        botonSelect.setBorder(null);
        botonSelect.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonSelect.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonSelectMouseClicked(evt);
            }
        });
        getContentPane().add(botonSelect, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 620, 30, 20));

        info.setBackground(new java.awt.Color(186, 172, 179));
        info.setFont(new java.awt.Font("MS Gothic", 1, 12)); // NOI18N
        info.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info.setText("<html><body> MÁS INFO </body></html>");
        info.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                infoFocusGained(evt);
            }
        });
        info.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                infoMouseEntered(evt);
            }
        });
        getContentPane().add(info, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 260, 180, -1));

        jIniciales.setBackground(new java.awt.Color(186, 172, 179));
        jIniciales.setFont(new java.awt.Font("MS Gothic", 1, 12)); // NOI18N
        jIniciales.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jIniciales.setText("<html><body> INTRODUCE TUS INICIALES <br> &nbsp; &nbsp; &nbsp; POR FAVOR: </body></html>");
        jIniciales.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jInicialesFocusGained(evt);
            }
        });
        jIniciales.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jInicialesMouseEntered(evt);
            }
        });
        getContentPane().add(jIniciales, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 240, 180, -1));

        txtIniciales.setBackground(new java.awt.Color(106, 128, 28));
        txtIniciales.setFont(new java.awt.Font("MS Gothic", 1, 12)); // NOI18N
        txtIniciales.setBorder(null);
        txtIniciales.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtInicialesFocusGained(evt);
            }
        });
        txtIniciales.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtInicialesMouseClicked(evt);
            }
        });
        txtIniciales.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtInicialesPropertyChange(evt);
            }
        });
        getContentPane().add(txtIniciales, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 280, 170, 20));

        separador.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        separador.setText("____________");
        separador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                separadorMouseClicked(evt);
            }
        });
        getContentPane().add(separador, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 280, -1, -1));

        botonArriba.setBorder(null);
        botonArriba.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonArriba.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonArribaMouseClicked(evt);
            }
        });
        getContentPane().add(botonArriba, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 500, 40, 30));

        botonAbajo.setBorder(null);
        botonAbajo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonAbajo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonAbajoMouseClicked(evt);
            }
        });
        getContentPane().add(botonAbajo, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 560, 40, 30));

        botonStart.setBorder(null);
        botonStart.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonStart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonStartMouseClicked(evt);
            }
        });
        getContentPane().add(botonStart, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 620, 50, 20));
        getContentPane().add(gameboy, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 310, 70, 70));
        getContentPane().add(foto, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 300, 100, 80));
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 880));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_botonAKeyPressed

    }//GEN-LAST:event_botonAKeyPressed

    
    //OnClick BOTON A:
    private void botonAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonAMouseClicked
        //Desactivamos botón
        botonStart.setEnabled(false);
        //Reproducimos sonido
        player.play("src/sonidos/botonA.wav");
        iniciales = txtIniciales.getText();
        //Comprobamos que las iniciales sean correctas
        if (comprobarIniciales(iniciales)) {
            //Cancelamos la animacion de la barra
            timer.cancel();
            //Hacemos transparentes algunos componentes e introducimos texto
            txtIniciales.setVisible(false);
            separador.setVisible(false);
            jIniciales.setText("<html><body> &nbsp; &nbsp;  COMPROBANDO TU <br>  &nbsp; &nbsp;  &nbsp; USUARIO... </html></body>");

            //Creamos una instancia de la clase consultar, para comprobar que el usuario existe
            Consultar cons = new Consultar(iniciales);
            //Instanciamos la clase Usuario  con las iniciales y la clase insercion
            Usuario usr = new Usuario(iniciales);
            Insertar ins = new Insertar();
            //Primero comprobaremos que las iniciales no existan en la BDD
            try {
                //Realizamos la consulta
                if (cons.consulta()) {
                    //En caso de que el usuario este repetido
                    if (cons.comprobar()) {
                        //Indicamos que ya existe, generamos sonido y animaciones
                        timer.cancel();
                        jIniciales.setText("<html><body> ESTE USUARIO <br>   YA EXISTE.. </html></body>");
                        player.play("src/sonidos/error.wav");
                        txtIniciales.setText("");
                        txtIniciales.setVisible(true);
                        separador.setVisible(true);
                        animacion(separador, animBarra, "", 10, 500);
                    }
                }

                //En caso de que el usuario no este repetido
                if (!cons.comprobar()) {
                    //Indicamos que el usuario se ha registrado exitosamente, generamos sonido y animaciones
                    timer.cancel();
                    jIniciales.setText("");
                    ins.registro(usr);
                    boolean registrado = true;
                    txtIniciales.setVisible(true);
                    player.play("src/sonidos/correcto.wav");
                    jIniciales.setText("<html><body> &nbsp;  USUARIO CREADO  <br> &nbsp; CORRECTAMENTE.. </html></body>");
                    animacion2(txtIniciales, " Pulsa SELECT ", "   Pulsa -> ", 10, 500);
                    gameboy.setVisible(false);
                }
            } catch (SQLException ex) {
                Logger.getLogger(Menu_GameBoy.class.getName()).log(Level.SEVERE, null, ex);
            }

            //En caso de que las iniciales no sean correctas
        } else {
            //Generamos sonidos e indicamos que debe introducirlas otra vez
            jIniciales.setText("");
            player.play("src/sonidos/error.wav");
            jIniciales.setText("<html><body>Iniciales incorrectas, <br> &nbsp; &nbsp; &nbsp; introduce<br> &nbsp;  &nbsp; &nbsp; solo tres.. </html></body>");
            animacion(separador, animBarra, "", 10, 500);
            txtIniciales.setText("");
        }
    }//GEN-LAST:event_botonAMouseClicked

    //OnClick BOTON ON:
    private void botonOnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonOnMouseClicked
        //Desactivamos el botón
        botonA.setEnabled(false);
        //Reproducimos el sonido de GameBoy
        player.play("src/sonidos/intro.wav");
        //Activamos el encendido
        encender(true);
        //Creamos la animación de la barra intermitente
        animacion(separador, animBarra, "", 10, 500);
        //Llamamos a la función animacionFoto, la cual pintará una foto de MarioBros intermitente
        animacionFoto("src/imagenes/mario.png", 10, 800);
    }//GEN-LAST:event_botonOnMouseClicked

    private void txtInicialesPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtInicialesPropertyChange
    }//GEN-LAST:event_txtInicialesPropertyChange

    //OnClick BOTON OFF:
    private void botonOffMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonOffMouseClicked
        //En caso de hacer click en el botón OFF, se finalizará la ejecución de la aplicación
        System.exit(0);
    }//GEN-LAST:event_botonOffMouseClicked

    //OnClick BOTON SELECT:
    private void botonSelectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonSelectMouseClicked
        //Al pulsar este botón, se desplegará el menú para jugar al snake
        //Desactivamos y activamos botones
        botonA.setEnabled(false);
        botonStart.setEnabled(true);
        //Cancelamos la animación
        timer.cancel();
        //Activamos los botones de desplazamiento
        botonArriba.setEnabled(true);
        botonAbajo.setEnabled(true);
        //Llamamos a animacion.Snake la cual generará el efecto de fondo itnermitente
        animacionSnake();
        //Seteamos texto a vacio
        txtIniciales.setText("");
        jIniciales.setText("");
        //Activamos los fondos
        jIniciales.setOpaque(true);
        info.setOpaque(true);
        info.setBackground(new java.awt.Color(106, 128, 28));
        //Activamos opción Jugar Snake
        jIniciales.setText("<html>JUGAR SNAKE</html>");
        info.setVisible(true);
        //Imprimimos la foto de Snake
        ImageIcon imagen = new ImageIcon("src/imagenes/sIcono.png");
        Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(foto.getWidth(), foto.getHeight(), Image.SCALE_DEFAULT));
        foto.setIcon(icono);
    }//GEN-LAST:event_botonSelectMouseClicked

    private void separadorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_separadorMouseClicked
    }//GEN-LAST:event_separadorMouseClicked

    //OnClick Introducir Iniciales:
    private void txtInicialesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtInicialesMouseClicked
        //En caso de hacer click en el JTextField, cancelamos la animación y centramos las iniciales
        timer.cancel();
        timer.cancel();
        separador.setText(animBarra);
        txtIniciales.setHorizontalAlignment(JLabel.CENTER);
    }//GEN-LAST:event_txtInicialesMouseClicked

    //OnClick Botón START:
    private void botonStartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonStartMouseClicked
        //Instanciamos snake y comienza el juego
        s = new Snake();
        finDatos();

    }//GEN-LAST:event_botonStartMouseClicked

    //Función para setear el texto final
    private void finDatos() {
        if (s.isShowing()) {
            //En caso de que se este ejecutando Snake
            timer.cancel();
            jIniciales.setOpaque(false);
            info.setText("");
            info.setOpaque(false);
            jIniciales.setForeground(Color.BLACK);
            jIniciales.setHorizontalAlignment(JLabel.CENTER);
            //Mostramos iniciales y resultados del usuario
            animacion(jIniciales, "<html><body> ¡ FELICIDADES " + iniciales + " ! <br>  Has obtenido " + s.getResultado() + "  puntos. </body></html>", "<html><body> Pulsa START para <br> volver a Jugar. </body></html>", 10, 800);
            jIniciales.setBackground(new java.awt.Color(106, 128, 28));
            fondo.setBackground(new java.awt.Color(106, 128, 28));
            animacionFoto("src/imagenes/corazon_1.png", 1, 400);
        }
    }


    private void txtInicialesFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtInicialesFocusGained
    }//GEN-LAST:event_txtInicialesFocusGained

    private void jInicialesFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jInicialesFocusGained

    }//GEN-LAST:event_jInicialesFocusGained

    private void jInicialesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jInicialesMouseEntered
    }//GEN-LAST:event_jInicialesMouseEntered

    private void infoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_infoFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_infoFocusGained

    private void infoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_infoMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_infoMouseEntered

    private void botonAbajoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonAbajoMouseClicked
        timer.cancel();
        ImageIcon imagen = new ImageIcon("src/imagenes/ayuda.png");
        Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(foto.getWidth(), foto.getHeight(), Image.SCALE_DEFAULT));
        foto.setIcon(icono);
        jIniciales.setBackground(new java.awt.Color(106, 128, 28));
        jIniciales.setForeground(Color.BLACK);
        info.setForeground(Color.BLACK);
        animacionInfo();
        JOptionPane.showMessageDialog(null, "<html><body>Para lanzar el juego, posicionate sobre JUGAR SNAKE y dale al botón START!!<br><br><b> Fernando </b></body></html>", "Enciéndeme!", JOptionPane.DEFAULT_OPTION, imageIcon);
    }//GEN-LAST:event_botonAbajoMouseClicked

    private void botonArribaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonArribaMouseClicked
        ImageIcon imagen = new ImageIcon("src/imagenes/sIcono.png");
        Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(foto.getWidth(), foto.getHeight(), Image.SCALE_DEFAULT));
        foto.setIcon(icono);
        timer.cancel();
        info.setBackground(new java.awt.Color(106, 128, 28));
        info.setForeground(Color.BLACK);
        animacionSnake();
    }//GEN-LAST:event_botonArribaMouseClicked

    //Función que copmrueba las iniciales que hemos introducido
    public boolean comprobarIniciales(String iniciales) {
        int tamaño = iniciales.length();
        boolean comp;
        if (tamaño == 3) {
            return true;
        }
        return false;
    }

    //Función que utilizaremos para activar o desactivar y hacer transparentes nuestros botones y JText
    public void encender(Boolean b) {
        //Por defecto, iniciamos todos los botones y campos, transparentes para el usuario
        //Botones transparentes:
        botonA.setContentAreaFilled(false);
        botonOn.setContentAreaFilled(false);
        botonOff.setContentAreaFilled(false);
        botonSelect.setContentAreaFilled(false);
        botonStart.setContentAreaFilled(false);
        botonArriba.setContentAreaFilled(false);
        botonAbajo.setContentAreaFilled(false);
        txtIniciales.setOpaque(false);

        info.setVisible(false);

        //Todos los botones desactivos menos el de ON
        botonA.setEnabled(b);
        botonOff.setEnabled(b);
        botonSelect.setEnabled(b);
        txtIniciales.setEnabled(b);
        botonStart.setEnabled(b);
        botonArriba.setEnabled(b);
        botonAbajo.setEnabled(b);

        //Los campos de texto invisibles
        jIniciales.setVisible(b);
        separador.setVisible(b);
    }

    //MAIN
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu_GameBoy().setVisible(true);
            }
        });
    }

    //Función auxiliar que utilizaremos para interrumpir la ejecución del programa si es necesario
    private static void delaySegundo() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
    }

    //ANIMACIONES:
    //Animacion de Foto_Mario
    public void animacionFoto(String ruta, int v1, int v2) {
        //Creamos un TimerTask, con una auxiliar 0, que irá diviendose entre 2, en caso de que sea 0, ejecutará una acción cada cierto tiempo especificado
        //gracias a timer.schedule
        timer = new Timer();
        TimerTask task = new TimerTask() {
            int aux = 0;

            public void run() {
                if (aux % 2 == 0) {
                    //Hacemos visible la foto y la pintamos
                    gameboy.setVisible(true);
                    ImageIcon imagen2 = new ImageIcon(ruta);
                    Icon icono = new ImageIcon(imagen2.getImage().getScaledInstance(gameboy.getWidth(), gameboy.getHeight(), Image.SCALE_DEFAULT));
                    gameboy.setIcon(icono);
                } else {
                    //La hacemos invisible
                    gameboy.setVisible(false);
                }
                //La auxiliar irá aumentando de valor
                aux++;
            }
        };
        // Empezamos dentro de 10ms y luego lanzamos la tarea cada 800ms
        timer.schedule(task, v1, v2);
    }

    //Animación Fondo Parpadeante Opc.1:
    private void animacionSnake() {
        timer = new Timer();
        TimerTask task = new TimerTask() {
            int aux = 0;

            public void run() {
                if (aux % 2 == 0) {
                    jIniciales.setForeground(Color.BLACK);
                    jIniciales.setBackground(new java.awt.Color(106, 128, 28));
                } else {
                    jIniciales.setForeground(new java.awt.Color(106, 128, 28));
                    jIniciales.setBackground(Color.BLACK);
                }
                aux++;
            }
        };
        timer.schedule(task, 10, 200);
    }

    //Animación Fondo Parpadeante Opc.2:
    private void animacionInfo() {
        timer = new Timer();
        TimerTask task = new TimerTask() {
            int aux = 0;

            public void run() {
                if (aux % 2 == 0) {
                    info.setForeground(Color.BLACK);
                    info.setBackground(new java.awt.Color(106, 128, 28));
                } else {
                    info.setForeground(new java.awt.Color(106, 128, 28));
                    info.setBackground(Color.BLACK);
                }
                aux++;
            }
        };
        // Empezamos dentro de 10ms y luego lanzamos la tarea cada 1000ms
        timer.schedule(task, 10, 200);
    }

    //Animación Barra Iniciales Parpadeante:
    public void animacion(JLabel jl, String texto1, String texto2, int v1, int v2) {

        timer = new Timer();
        TimerTask task = new TimerTask() {
            int aux = 0;

            public void run() {
                if (aux % 2 == 0) {
                    jl.setText(texto1);
                } else {
                    jl.setText(texto2);
                }
                aux++;
            }
        };
        timer.schedule(task, v1, v2);
    }

    //Animación Texto Parpadeante:
    public void animacion2(JTextField jl, String texto1, String texto2, int v1, int v2) {

        timer = new Timer();
        TimerTask task = new TimerTask() {
            int aux = 0;

            public void run() {
                if (aux % 2 == 0) {
                    jl.setText(texto1);
                } else {
                    jl.setText(texto2);
                }
                aux++;
            }
        };
        // Empezamos dentro de 10ms y luego lanzamos la tarea cada 1000ms
        timer.schedule(task, v1, v2);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonA;
    private javax.swing.JButton botonAbajo;
    private javax.swing.JButton botonArriba;
    private javax.swing.JButton botonOff;
    private javax.swing.JButton botonOn;
    private javax.swing.JButton botonSelect;
    private javax.swing.JButton botonStart;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel foto;
    private javax.swing.JLabel gameboy;
    private javax.swing.JLabel info;
    private javax.swing.JLabel jIniciales;
    private javax.swing.JLabel separador;
    private javax.swing.JTextField txtIniciales;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
