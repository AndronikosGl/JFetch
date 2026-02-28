/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jfetch;

import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UnsupportedLookAndFeelException;
import java.awt.DisplayMode;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.lang.management.RuntimeMXBean;
import java.util.concurrent.atomic.AtomicInteger;
import javax.management.AttributeNotFoundException;
import javax.management.InstanceNotFoundException;
import javax.management.MBeanException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.ReflectionException;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import janimator.JAnimator;
import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.prefs.Preferences;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author andronikos
 */
public final class main extends javax.swing.JFrame {

    JFrame reference;
    boolean theme = false; //Theme
    Preferences prefs = Preferences.userNodeForPackage(main.class);
    Icon dark = new ImageIcon(main.class.getResource("dark.png"));
    Icon light = new ImageIcon(main.class.getResource("light.png"));
    Icon darkh = new ImageIcon(main.class.getResource("hoverdark.png"));
    Icon lighth = new ImageIcon(main.class.getResource("hoverlight.png"));
    Icon gray = new ImageIcon(main.class.getResource("switch.gif"));
    Icon grayrev = new ImageIcon(main.class.getResource("switchrev.gif"));

    private volatile boolean repeatlock = false;

    /**
     * Creates new form main
     */
    public static void ConfigurePictureBoxWH(JLabel Label, String ResourceName, String Quality, int w, int h, boolean Remove_label_text) {
        if (Remove_label_text == false) {
            Label.setText(""); // Να μην εμποδιζει την εικονα το κειμενο σε περιπτωση που θελλω να το εχω σαν picture element   
        }
        ImageIcon icon = new ImageIcon(main.class.getResource(ResourceName));
        Image scaledImage = icon.getImage().getScaledInstance(w, h, Image.SCALE_DEFAULT);
        switch (Quality) {
            case "SMOOTH":
                scaledImage = icon.getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH);
                break;
            case "FAST":
                scaledImage = icon.getImage().getScaledInstance(w, h, Image.SCALE_FAST);
                break;
            case "AREA_AVERAGING":
                scaledImage = icon.getImage().getScaledInstance(w, h, Image.SCALE_AREA_AVERAGING);
                ;
                break;
            default:
                scaledImage = icon.getImage().getScaledInstance(w, h, Image.SCALE_DEFAULT);
                break;
        }
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        Label.setIcon(scaledIcon);
    }

    public void setDistroLogo() throws IOException {
        String osname;
        Process proc;
        BufferedReader buff;
        if (System.getProperty("os.name").toLowerCase().contains("linux")) {
            String[] cmd = {"/bin/bash", "-c", "awk -F= '/^NAME=/{gsub(/\"/, \"\", $2); print $2}' /etc/os-release"};
            proc = Runtime.getRuntime().exec(cmd);
            buff = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            osname = buff.readLine().replace("NAME=", "");
            if (osname.toLowerCase().contains("alpine")) {
                logo.setIcon(new ImageIcon(main.class.getResource("distrologos/alpine.png")));
            } else if (osname.toLowerCase().contains("antix")) {
                logo.setIcon(new ImageIcon(main.class.getResource("distrologos/antix.png")));
            } else if (osname.toLowerCase().contains("archcraft")) {
                logo.setIcon(new ImageIcon(main.class.getResource("distrologos/archcraft.png")));
            } else if (osname.toLowerCase().contains("blackarch")) {
                logo.setIcon(new ImageIcon(main.class.getResource("distrologos/blackarch.png")));
            } else if (osname.toLowerCase().contains("arch")) {
                logo.setIcon(new ImageIcon(main.class.getResource("distrologos/arch.png")));
            } else if (osname.toLowerCase().contains("cent")) {
                logo.setIcon(new ImageIcon(main.class.getResource("distrologos/cent.png")));
            } else if (osname.toLowerCase().contains("deepin")) {
                logo.setIcon(new ImageIcon(main.class.getResource("distrologos/antix.png")));
            } else if (osname.toLowerCase().contains("edubuntu")) {
                logo.setIcon(new ImageIcon(main.class.getResource("distrologos/edubuntu.png")));
            } else if (osname.toLowerCase().contains("elementary")) {
                logo.setIcon(new ImageIcon(main.class.getResource("distrologos/elementary.png")));
            } else if (osname.toLowerCase().contains("endeavour")) {
                logo.setIcon(new ImageIcon(main.class.getResource("distrologos/endavour.png")));
            } else if (osname.toLowerCase().contains("fedora")) {
                logo.setIcon(new ImageIcon(main.class.getResource("distrologos/fedora.png")));
            } else if (osname.toLowerCase().contains("garuda")) {
                logo.setIcon(new ImageIcon(main.class.getResource("distrologos/garunda.png")));
            } else if (osname.toLowerCase().contains("gentoo")) {
                logo.setIcon(new ImageIcon(main.class.getResource("distrologos/gentoo.png")));
            } else if (osname.toLowerCase().contains("kde")) {
                logo.setIcon(new ImageIcon(main.class.getResource("distrologos/kdeneon.png")));
            } else if (osname.toLowerCase().contains("kubuntu")) {
                logo.setIcon(new ImageIcon(main.class.getResource("distrologos/kubuntu.png")));
            } else if (osname.toLowerCase().contains("lfs")) {
                logo.setIcon(new ImageIcon(main.class.getResource("distrologos/lfs.png")));
            } else if (osname.toLowerCase().contains("lite")) {
                logo.setIcon(new ImageIcon(main.class.getResource("distrologos/linuxlite.png")));
            } else if (osname.toLowerCase().contains("lubuntu")) {
                logo.setIcon(new ImageIcon(main.class.getResource("distrologos/lubuntu.png")));
            } else if (osname.toLowerCase().contains("manjaro")) {
                logo.setIcon(new ImageIcon(main.class.getResource("distrologos/manjoro.png")));
            } else if (osname.toLowerCase().contains("mint")) {
                logo.setIcon(new ImageIcon(main.class.getResource("distrologos/mint.png")));
            } else if (osname.toLowerCase().contains("mx")) {
                logo.setIcon(new ImageIcon(main.class.getResource("distrologos/mx.png")));
            } else if (osname.toLowerCase().contains("nix")) {
                logo.setIcon(new ImageIcon(main.class.getResource("distrologos/nix.png")));
            } else if (osname.toLowerCase().contains("opensuse")) {
                logo.setIcon(new ImageIcon(main.class.getResource("distrologos/opensuse.png")));
            } else if (osname.toLowerCase().contains("pclinux")) {
                logo.setIcon(new ImageIcon(main.class.getResource("distrologos/pclinux.png")));
            } else if (osname.toLowerCase().contains("peppermint")) {
                logo.setIcon(new ImageIcon(main.class.getResource("distrologos/pepermint.png")));
            } else if (osname.toLowerCase().contains("pop")) {
                logo.setIcon(new ImageIcon(main.class.getResource("distrologos/popos.png")));
            } else if (osname.toLowerCase().contains("puppy")) {
                logo.setIcon(new ImageIcon(main.class.getResource("distrologos/puppy.png")));
            } else if (osname.toLowerCase().contains("raspberry") || osname.toLowerCase().contains("raspbian")) {
                logo.setIcon(new ImageIcon(main.class.getResource("distrologos/rasbian.png")));
            } else if (osname.toLowerCase().contains("redhat")) {
                logo.setIcon(new ImageIcon(main.class.getResource("distrologos/redhat.png")));
            } else if (osname.toLowerCase().contains("slackware")) {
                logo.setIcon(new ImageIcon(main.class.getResource("distrologos/slackware.png")));
            } else if (osname.toLowerCase().contains("suse")) {
                logo.setIcon(new ImageIcon(main.class.getResource("distrologos/suse.png")));
            } else if (osname.toLowerCase().contains("tails")) {
                logo.setIcon(new ImageIcon(main.class.getResource("distrologos/tails.png")));
            } else if (osname.toLowerCase().contains("tinycore")) {
                logo.setIcon(new ImageIcon(main.class.getResource("distrologos/tinycore.png")));
            } else if (osname.toLowerCase().contains("mate") && osname.toLowerCase().contains("ubuntu")) {
                logo.setIcon(new ImageIcon(main.class.getResource("distrologos/ubuntu-mate.png")));
            } else if (osname.toLowerCase().contains("ubuntu")) {
                logo.setIcon(new ImageIcon(main.class.getResource("distrologos/ubuntu.png")));
            } else if (osname.toLowerCase().contains("void")) {
                logo.setIcon(new ImageIcon(main.class.getResource("distrologos/void.png")));
            } else if (osname.toLowerCase().contains("xubuntu")) {
                logo.setIcon(new ImageIcon(main.class.getResource("distrologos/xubuntu.png")));
            } else if (osname.toLowerCase().contains("zorin")) {
                logo.setIcon(new ImageIcon(main.class.getResource("distrologos/zorin.png")));
            } else {
                logo.setIcon(new ImageIcon(main.class.getResource("distrologos/linux.png")));
            }

        } else if (System.getProperty("os.name").toLowerCase().contains("bsd")) {
            if (System.getProperty("os.name").toLowerCase().contains("free")) {
                logo.setIcon(new ImageIcon(main.class.getResource("distrologos/freebsd.png")));
            } else if (System.getProperty("os.name").toLowerCase().contains("net")) {
                logo.setIcon(new ImageIcon(main.class.getResource("distrologos/netbsd.png")));
            } else if (System.getProperty("os.name").toLowerCase().contains("open")) {
                logo.setIcon(new ImageIcon(main.class.getResource("distrologos/openbsd.png")));
            }
        } else if (System.getProperty("os.name").toLowerCase().contains("sunos")) {
            logo.setIcon(new ImageIcon(main.class.getResource("distrologos/solaris.png")));
        } else {
            logo.setIcon(new ImageIcon(main.class.getResource("distrologos/unix.png")));
        }
    }

    public String[] ReturnInfo() throws IOException, MalformedObjectNameException, MBeanException, AttributeNotFoundException, InstanceNotFoundException, ReflectionException {

        String[] info = new String[9];
        Process proc = Runtime.getRuntime().exec("uname -r");
        BufferedReader buff = new BufferedReader(new InputStreamReader(proc.getInputStream()));
        info[1] = buff.readLine();
        proc = Runtime.getRuntime().exec("hostname");
        buff = new BufferedReader(new InputStreamReader(proc.getInputStream()));
        info[2] = buff.readLine();
        String[] shell = {"sh", "-c", "echo $SHELL"};
        proc = Runtime.getRuntime().exec(shell);
        buff = new BufferedReader(new InputStreamReader(proc.getInputStream()));
        info[3] = buff.readLine();
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        DisplayMode dm = gd.getDisplayMode();
        int width = dm.getWidth();
        int height = dm.getHeight();
        info[4] = width + "x" + height;
        reference = this;
        if (System.getProperty("os.name").toLowerCase().contains("linux")) {
            String[] cmd = {"/bin/bash", "-c", "awk -F= '/^NAME=/{gsub(/\"/, \"\", $2); print $2}' /etc/os-release"};
            proc = Runtime.getRuntime().exec(cmd);
            buff = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            info[0] = buff.readLine().replace("NAME=", "");
            Process cpu = Runtime.getRuntime().exec(new String[]{"sh", "-c", "lscpu | grep 'Model name' | awk -F: '{print $2}' "});
            BufferedReader buff2 = new BufferedReader(new InputStreamReader(cpu.getInputStream()));
            info[6] = buff2.readLine().trim();
            Process btime;

            btime = Runtime.getRuntime().exec(new String[]{
                "sh", "-c", "systemd-analyze | grep 'Startup finished in' | sed -E 's/.*= ([0-9]+)(\\.[0-9]+)?s.*/\\1/'"
            });
            BufferedReader buff3 = new BufferedReader(new InputStreamReader(btime.getInputStream()));
            info[7] = buff3.readLine();
            //Boottime on linux
            //systemd-analyze | head -n 1 | awk -F'=' '{print $2}' | awk '{min=($1 ~ /min/) ? $1+0 : 0; sec=($2+0); printf "%.0f\n", (min * 60) + sec}'
        } else if (System.getProperty("os.name").toLowerCase().contains("bsd")) {
            info[0] = System.getProperty("os.name") + " " + System.getProperty("os.arch");
            Process cpu = Runtime.getRuntime().exec("sysctl -n hw.model");
            BufferedReader buff2 = new BufferedReader(new InputStreamReader(cpu.getInputStream()));
            info[6] = buff2.readLine();
            //sysctl -n kern.boottime | sed -n 's/.*sec = \([0-9]*\).*/\1/p'

            info[7] = "0";

        } else if ((System.getProperty("os.name").toLowerCase().contains("sunos")) || (System.getProperty("os.name").toLowerCase().contains("solaris"))) {
            Process cpu = Runtime.getRuntime().exec("isalist");
            BufferedReader buff2 = new BufferedReader(new InputStreamReader(cpu.getInputStream()));
            String out = buff2.readLine();
            if (out.length() > 34) {
                info[6] = out.substring(0, 31) + "...";
            } else {
                info[6] = out;
            }
            info[7] = "0";
        } else {
            JOptionPane.showMessageDialog(main.this, "JFetch is only supported on linux, BSD and Solaris systems", "Unsupported OS", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
        MBeanServer mbeanserver = ManagementFactory.getPlatformMBeanServer();
        Object attribute = mbeanserver.getAttribute(new ObjectName("java.lang", "type", "OperatingSystem"), "TotalPhysicalMemorySize");
        double gb = (double) Long.parseLong(attribute.toString()) / 1024 / 1024 / 1024;
        info[5] = gb < 1 ? String.format("%.2fGB", gb) : ((int) Math.ceil(gb)) + "GB";
        File data = new File("/");
        int free = (int) Math.ceil((data.getUsableSpace() / (1024.0 * 1024 * 1024)));
        int total = (int) Math.ceil((data.getTotalSpace() / (1024.0 * 1024 * 1024)));
        int used = total - free;
        int percentUsed = (int) Math.round((used / (double) total) * 100);
        info[8] = String.valueOf(free) + "GB/" + String.valueOf(total) + "GB (" + percentUsed + "% full)";
        return info;
    }

    public void animateDarkLight(boolean direction) {

    }

    public main() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException, IOException, MalformedObjectNameException, MBeanException, AttributeNotFoundException, InstanceNotFoundException, ReflectionException, FontFormatException {
        initComponents();
        theme = prefs.getBoolean("isdark", false);
        getContentPane().setBackground(new Color(242, 242, 242));
        if (theme == true) {
            HoverEffect.setIcon(darkh);
            HoverEffect2.setIcon(darkh);
            Colorbar.setBorder(BorderFactory.createLineBorder(Color.WHITE));
            Content.setForeground(Color.WHITE);
            uptime.setIcon(new ImageIcon(main.class.getResource("uptime-dark.png")));
            copy.setIcon(new ImageIcon(main.class.getResource("screenshot-dark.png")));
            uptime.setForeground(Color.white);
            getContentPane().setBackground(new Color(34, 34, 34));
            tbi.setIcon(light);

        } else {
            HoverEffect.setIcon(lighth);
            HoverEffect2.setIcon(lighth);
            Colorbar.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            Content.setForeground(Color.BLACK);
            uptime.setIcon(new ImageIcon(main.class.getResource("uptime.png")));
            copy.setIcon(new ImageIcon(main.class.getResource("screenshot-light.png")));
            uptime.setForeground(Color.black);
            getContentPane().setBackground(new Color(244, 244, 244));
            tbi.setIcon(dark);
        }
        pack(); // let Swing calculate preferred sizes

// Get actual window decorations
        Insets insets = getInsets(); // top, bottom, left, right

// Calculate total height for window
        int desiredHeight = Colorbar.getY() + Colorbar.getHeight() + 20; // content padding
        desiredHeight += insets.top + insets.bottom; // add title bar + borders

        setSize(617, desiredHeight);
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(617, desiredHeight));
        this.setIconImage(new ImageIcon(main.class.getResource("icon.png")).getImage());
        setDistroLogo();
        Content.setText("<html>"
                + "<p style='margin: 0 0 5px 0;'><b>OS:</b> " + ReturnInfo()[0] + "</p>"
                + "<p style='margin: 0 0 5px 0;'><b>Kernel:</b> " + ReturnInfo()[1] + "</p>"
                + "<p style='margin: 0 0 5px 0;'><b>Host:</b> " + ReturnInfo()[2] + "</p>"
                + "<p style='margin: 0 0 5px 0;'><b>Shell:</b> " + ReturnInfo()[3] + "</p>"
                + "<p style='margin: 0 0 5px 0;'><b>Resolution:</b> " + ReturnInfo()[4] + "</p>"
                + "<p style='margin: 0 0 5px 0;'><b>RAM:</b> " + ReturnInfo()[5] + "</p>"
                + "<p style='margin: 0 0 5px 0;'><b>CPU:</b> " + ReturnInfo()[6] + "</p>"
                + "<p style='margin: 0 0 5px 0;'><b>Disk:</b> " + ReturnInfo()[8] + "</p>"
                + "</html>");
        JAnimator ani1 = new JAnimator(Content, 10, 0, JAnimator.AnimationType.FADE, true);
        ani1.playIn();
        HoverEffect.hide();
        HoverEffect2.hide();
        InputStream fontfile = main.class.getResourceAsStream("7seg.ttf");
        Font seg7ttf = Font.createFont(Font.TRUETYPE_FONT, fontfile).deriveFont(20f);
        GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(seg7ttf);
        InputStream fontforC = main.class.getResourceAsStream("14seg.ttf");
        Font seg14ttf = Font.createFont(Font.TRUETYPE_FONT, fontforC).deriveFont(20f);
        GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(seg14ttf);
        uptime.setFont(seg7ttf); // still set for layout sizing etc.
        var bootdur = Integer.parseInt(ReturnInfo()[7]);

        Timer aniend = new Timer(310, new ActionListener() {
            int i = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (String.valueOf(bootdur).startsWith("1")) {
                    uptime.setIconTextGap(-3); // tweak this as needed
                } else {
                    uptime.setIconTextGap(9);
                }
                if (i <= 3) {
                    if (i % 2 == 1) {
                        uptime.setText("<html>"
                                + "<span style='font-family:\"" + seg7ttf.getFontName() + "\"; font-size:20pt;'>"
                                + bootdur + " 5E</span>"
                                + "<span style='font-family:\"" + seg14ttf.getFontName() + "\"; font-size:20pt;'>C</span>"
                                + "</html>");
                        uptime.repaint();
                    } else {
                        uptime.setText("");
                        uptime.repaint();
                    }
                    i++;

                } else {
                    ((Timer) e.getSource()).stop();
                }

            }
        });
        new Timer(50, new ActionListener() {
            int i = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (ReturnInfo()[7].equals("0")) {
                        uptime.setText("<html>"
                                + "<span style='font-family:\"" + "sans-serif" + "\"; font-size:14pt; font-weight:bold;'>"
                                + "&nbsp;Unavailable" + " </span>"
                                + "<span style='font-family:\"" + seg14ttf.getFontName() + "\"; font-size:20pt;'></span>"
                                + "</html>");
                        ((Timer) e.getSource()).stop();
                    } else {
                        if (i <= bootdur) {
                            if (String.valueOf(i).startsWith("1")) {
                                uptime.setIconTextGap(-3); // tweak this as needed
                            } else {
                                uptime.setIconTextGap(9);
                            }
                            uptime.setText("<html>"
                                    + "<span style='font-family:\"" + seg7ttf.getFontName() + "\"; font-size:20pt;'>"
                                    + i + " 5E</span>"
                                    + "<span style='font-family:\"" + seg14ttf.getFontName() + "\"; font-size:20pt;'>C</span>"
                                    + "</html>");
                            uptime.repaint();
                            if (bootdur <= 24) {
                                i++;
                            } else if (bootdur > 24 && bootdur < 40) {
                                i += 2;
                            } else if (bootdur > 40 && bootdur < 60) {
                                i += 5;
                            } else {
                                i = bootdur;
                            }

                        } else {
                            aniend.start();

                            ((Timer) e.getSource()).stop();
                        }
                    }
                } catch (IOException ex) {
                    Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
                } catch (MalformedObjectNameException ex) {
                    Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
                } catch (MBeanException ex) {
                    Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
                } catch (AttributeNotFoundException ex) {
                    Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstanceNotFoundException ex) {
                    Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ReflectionException ex) {
                    Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        uptime = new javax.swing.JLabel();
        separator = new javax.swing.JLabel();
        copy = new javax.swing.JLabel();
        HoverEffect2 = new javax.swing.JLabel();
        Content = new javax.swing.JLabel();
        Colorbar = new javax.swing.JLabel();
        tbi = new javax.swing.JLabel();
        HoverEffect = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("jfetch 1.0");
        setBackground(new java.awt.Color(51, 51, 51));
        setLocation(new java.awt.Point(50, 50));
        setLocationByPlatform(true);
        setResizable(false);
        getContentPane().setLayout(null);

        uptime.setFont(new java.awt.Font("DS-Digital", 0, 27)); // NOI18N
        uptime.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        uptime.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jfetch/uptime.png"))); // NOI18N
        uptime.setText("-- SEC");
        uptime.setToolTipText("Boot time");
        uptime.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                uptimeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                uptimeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                uptimeMouseExited(evt);
            }
        });
        getContentPane().add(uptime);
        uptime.setBounds(130, 290, 130, 40);

        separator.setFont(new java.awt.Font("Inter Light", 0, 24)); // NOI18N
        separator.setForeground(new java.awt.Color(153, 153, 153));
        separator.setText("|");
        getContentPane().add(separator);
        separator.setBounds(113, 290, 10, 40);

        copy.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        copy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jfetch/screenshot-light.png"))); // NOI18N
        copy.setToolTipText("Copy results");
        copy.setDoubleBuffered(true);
        copy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                copyMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                copyMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                copyMouseExited(evt);
            }
        });
        getContentPane().add(copy);
        copy.setBounds(65, 290, 40, 40);

        HoverEffect2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jfetch/hoverlight.png"))); // NOI18N
        getContentPane().add(HoverEffect2);
        HoverEffect2.setBounds(65, 290, 40, 40);

        Content.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        Content.setText("Please wait...");
        Content.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(Content);
        Content.setBounds(215, 21, 400, 260);

        Colorbar.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        Colorbar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Colorbar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jfetch/colorbar.png"))); // NOI18N
        Colorbar.setToolTipText("");
        Colorbar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Colorbar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(Colorbar);
        Colorbar.setBounds(270, 290, 330, 41);

        tbi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tbi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jfetch/dark.png"))); // NOI18N
        tbi.setToolTipText("Theme toggle");
        tbi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbiMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tbiMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tbiMouseExited(evt);
            }
        });
        getContentPane().add(tbi);
        tbi.setBounds(20, 290, 40, 40);

        HoverEffect.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jfetch/hoverlight.png"))); // NOI18N
        getContentPane().add(HoverEffect);
        HoverEffect.setBounds(20, 290, 40, 40);

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jfetch/distrologos/zorin.png"))); // NOI18N
        getContentPane().add(logo);
        logo.setBounds(17, 21, 190, 190);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void uptimeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_uptimeMouseEntered

    }//GEN-LAST:event_uptimeMouseEntered

    private void uptimeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_uptimeMouseExited

    }//GEN-LAST:event_uptimeMouseExited

    private void uptimeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_uptimeMouseClicked

    }//GEN-LAST:event_uptimeMouseClicked

    private void tbiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbiMouseClicked
        if (!repeatlock && theme == false) {
            AtomicInteger opmax = new AtomicInteger(242);
            repeatlock = true;
            HoverEffect.setIcon(darkh);
            HoverEffect2.setIcon(darkh);
            tbi.setIcon(gray);
            new javax.swing.Timer(10, e -> {
                if (opmax.get() < 210) {
                    tbi.setIcon(light);
                }
                if (opmax.get() > 36) {
                    opmax.addAndGet(-4);
                    repaint();
                } else {
                    ((javax.swing.Timer) e.getSource()).stop();
                    theme = true;
                    repeatlock = false;

                }

                prefs.putBoolean("isdark", true);
                Colorbar.setBorder(BorderFactory.createLineBorder(Color.WHITE));
                Content.setForeground(Color.WHITE);
                uptime.setIcon(new ImageIcon(main.class.getResource("uptime-dark.png")));
                copy.setIcon(new ImageIcon(main.class.getResource("screenshot-dark.png")));
                uptime.setForeground(Color.white);
                getContentPane().setBackground(new Color(opmax.get(), opmax.get(), opmax.get()));

            }).start();
        } else if (!repeatlock && theme == true) {
            AtomicInteger opmax = new AtomicInteger(36);
            repeatlock = true;
            HoverEffect.setIcon(lighth);
            HoverEffect2.setIcon(lighth);
            tbi.setIcon(gray);
            new javax.swing.Timer(10, e -> {
                if (opmax.get() > 66) {
                    tbi.setIcon(dark);
                }
                if (opmax.get() < 242) {
                    opmax.addAndGet(4);
                    repaint();
                } else {
                    ((javax.swing.Timer) e.getSource()).stop();
                    theme = false;
                    repeatlock = false;

                }

                prefs.putBoolean("isdark", false);
                Colorbar.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                Content.setForeground(Color.BLACK);
                uptime.setIcon(new ImageIcon(main.class.getResource("uptime.png")));
                copy.setIcon(new ImageIcon(main.class.getResource("screenshot-light.png")));
                uptime.setForeground(Color.black);

                getContentPane().setBackground(new Color(opmax.get(), opmax.get(), opmax.get()));

            }).start();
        }
    }//GEN-LAST:event_tbiMouseClicked

    private void tbiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbiMouseEntered
        HoverEffect.show();
    }//GEN-LAST:event_tbiMouseEntered

    private void tbiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbiMouseExited
        HoverEffect.hide();
    }//GEN-LAST:event_tbiMouseExited

    private void copyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_copyMouseClicked
        if (theme == false) {
            ConfigurePictureBoxWH(copy, "check-light.png", "SMOOTH", 19, 19, true);
        } else {
            ConfigurePictureBoxWH(copy, "check-dark.png", "SMOOTH", 19, 19, true);
        }
        JAnimator chekani = new JAnimator(copy, 30, 0, JAnimator.AnimationType.ZOOM, true);
        chekani.playIn();
        Rectangle contrect = reference.getContentPane().getBounds();
        Point p = reference.getContentPane().getLocationOnScreen();
        Rectangle rect = new Rectangle(p, contrect.getSize());
        try {
            Robot robot = new Robot();
            BufferedImage buff = robot.createScreenCapture(rect);
            Transferable imgsel = new Transferable() {
                private final Image img = buff;

                @Override
                public DataFlavor[] getTransferDataFlavors() {
                    return new DataFlavor[]{DataFlavor.imageFlavor};
                }

                @Override
                public boolean isDataFlavorSupported(DataFlavor flavor) {
                    return DataFlavor.imageFlavor.equals(flavor);
                }

                @Override
                public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException {
                    if (!isDataFlavorSupported(flavor)) {
                        throw new UnsupportedFlavorException(flavor);
                    }
                    return img;
                }
            };
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(imgsel, null);

            if (SystemTray.isSupported()) {
                SystemTray tray = SystemTray.getSystemTray();
                BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
                TrayIcon trayicon = new TrayIcon(img, "JFetch");
                tray.add(trayicon);
                trayicon.displayMessage("Specs screenshot taken", "Your screenshot of this window is taken. You can officially now flex on social media!", TrayIcon.MessageType.INFO);
            } else {
                try {
                    Runtime.getRuntime().exec(new String[]{
                        "notify-send", "Specs screenshot taken", "Your screenshot of this window is copied to clipboard. You can officially now flex on social media!"
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (AWTException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            new Thread(() -> {
                try {
                    Thread.sleep(800);
                } catch (InterruptedException ex) {
                    Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (theme == false) {
                    ConfigurePictureBoxWH(copy, "screenshot-light.png", "SMOOTH", 28, 28, true);
                } else {
                    ConfigurePictureBoxWH(copy, "screenshot-dark.png", "SMOOTH", 28, 28, true);
                }
            }).start();
        }
    }//GEN-LAST:event_copyMouseClicked

    private void copyMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_copyMouseEntered
        HoverEffect2.show();
    }//GEN-LAST:event_copyMouseEntered

    private void copyMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_copyMouseExited
        HoverEffect2.hide();
    }//GEN-LAST:event_copyMouseExited

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new main().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
                } catch (MalformedObjectNameException ex) {
                    Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
                } catch (MBeanException ex) {
                    Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
                } catch (AttributeNotFoundException ex) {
                    Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstanceNotFoundException ex) {
                    Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ReflectionException ex) {
                    Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
                } catch (FontFormatException ex) {
                    Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Colorbar;
    private javax.swing.JLabel Content;
    private javax.swing.JLabel HoverEffect;
    private javax.swing.JLabel HoverEffect2;
    private javax.swing.JLabel copy;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel separator;
    private javax.swing.JLabel tbi;
    private javax.swing.JLabel uptime;
    // End of variables declaration//GEN-END:variables
}
