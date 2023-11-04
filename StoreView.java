/**
 * @author  Yash Kapoor
 * @version 5.0
 */

// Student ID: 101163338

package myStore;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StoreView {

    private long id;
    private StoreManager sm;

    private final JFrame FRAME;

    private final JButton EMPTY_CART;
    private final JButton CHECKOUT;

    private final JButton ADD;
    private final JButton REMOVE;

    private final JButton ADD2;
    private final JButton REMOVE2;

    private final JButton ADD3;
    private final JButton REMOVE3;

    private final JButton ADD4;
    private final JButton REMOVE4;

    private final JButton ADD5;
    private final JButton REMOVE5;

    private final JButton ADD6;
    private final JButton REMOVE6;

    private final JButton ADD7;
    private final JButton REMOVE7;

    private final JTextArea INFO;
    private final JLabel HEADER_LABEL;

    private final JLabel POTATOES_INFO;
    private final JLabel BREAD_INFO;
    private final JLabel CEREAL_INFO;
    private final JLabel MAPLE_SYRUP_INFO;
    private final JLabel BAGELS_INFO;
    private final JLabel OATMEAL_INFO;
    private final JLabel WAFFLES_INFO;

    /**
     * Constructor for StoreView
     */
    private StoreView(StoreManager sm, long id) {

        this.id = id;
        this.sm = sm;

        this.FRAME = new JFrame();

        this.ADD = new JButton("+");
        this.REMOVE = new JButton("-");

        this.ADD2 = new JButton("+");
        this.REMOVE2 = new JButton("-");

        this.ADD3 = new JButton("+");
        this.REMOVE3 = new JButton("-");

        this.ADD4 = new JButton("+");
        this.REMOVE4 = new JButton("-");

        this.ADD5 = new JButton("+");
        this.REMOVE5 = new JButton("-");

        this.ADD6 = new JButton("+");
        this.REMOVE6 = new JButton("-");

        this.ADD7 = new JButton("+");
        this.REMOVE7 = new JButton("-");

        this.HEADER_LABEL = new JLabel();

        this.EMPTY_CART = new JButton("Empty Cart");
        this.CHECKOUT = new JButton("Checkout");
        this.CHECKOUT.setEnabled(false);
        this.EMPTY_CART.setEnabled(false);

        this.INFO = new JTextArea();
        this.INFO.setEditable(false);

        this.POTATOES_INFO = new JLabel();
        this.BREAD_INFO = new JLabel();
        this.CEREAL_INFO = new JLabel();
        this.MAPLE_SYRUP_INFO = new JLabel();
        this.BAGELS_INFO = new JLabel();
        this.OATMEAL_INFO = new JLabel();
        this.WAFFLES_INFO = new JLabel();
    }

    /**
     * Sets the title of the JFrame
     */
    private void showGUI() {
        FRAME.setTitle("Client StoreView");

        FRAME.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                titleCenterAlign(FRAME);
            }

        });

    }

    /**
     * Center aligns the title of the JFrame
     */
    private void titleCenterAlign(JFrame frame) {
        Font font = frame.getFont();

        String ct = frame.getTitle().trim();
        FontMetrics fm = frame.getFontMetrics(font);
        int fw = frame.getWidth();
        int tw = fm.stringWidth(ct);
        int sw = fm.stringWidth(" ");
        int cp = (fw / 2) - (tw / 2);
        int sc = cp / sw;

        String pad = "";

        // adding spaces to center align the title
        pad = String.format("%" + (sc - 11) + "s", pad);
        frame.setTitle(pad + ct);

    }

    /**
     * Get a JPanel that is the header panel
     * that contains a label with a title
     *
     * @return JPanel : a JPanel object.
     */
    private JPanel getHeader() {

        // setting the text, foreground color, and the font style
        HEADER_LABEL.setText("Welcome to the Food Store! Cart ID >>> 0");
        HEADER_LABEL.setFont(new Font("Serif", Font.BOLD, 30));
        HEADER_LABEL.setForeground(Color.BLACK);

        JPanel headerPanel = new JPanel();

        headerPanel.add(HEADER_LABEL);
        // setting the preferred sizes and colours
        headerPanel.setPreferredSize(new Dimension(250, 100));
        headerPanel.setBackground(Color.GRAY);

        return headerPanel;
    }

    /**
     * Get a JButton that generates a new cart ID
     *
     * @return JButton : a JButton object.
     */
    private JButton getNewCartID() {

        JButton newCartID = new JButton("Get a New Cart");

        newCartID.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                long newID = id++;

                // unique ID generated whenever user clicks on this button
                HEADER_LABEL.setText("Welcome to the Food Store! Cart ID >>> " + newID);

                if(sm.getCart().size() != 0) {
                    // message displayed to user after a new cart is requested
                    JOptionPane pane = new JOptionPane("Your items have been transferred over to your new cart.");
                    JDialog dialog = pane.createDialog(null, "New Cart ID: " + newID);
                    dialog.setVisible(true);
                }
            }
        });

        return newCartID;
    }

    /**
     * Get a JButton that empties the user's cart
     *
     * @return JButton : a JButton object.
     */
    private JButton getEmptyCart() {

        EMPTY_CART.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                INFO.setText("");

                sm.emptyCart();
                // cart is emptied

                JOptionPane.showMessageDialog(null, "Your cart has been emptied!");
                // letting the user know that they have emptied their cart

                CHECKOUT.setEnabled(false);
                EMPTY_CART.setEnabled(false);


                // displaying the updated stock in the inventory after cart has been emptied
                POTATOES_INFO.setText("Potatoes:     Price: $4.00 - Stock: " + sm.inStock(101));
                BREAD_INFO.setText("Bread:     Price: $7.00 - Stock: " + sm.inStock(106));
                CEREAL_INFO.setText("Cereal:     Price: $6.00 - Stock: " + sm.inStock(103));
                OATMEAL_INFO.setText("Oatmeal:     Price: $4.50 - Stock: " + sm.inStock(104));
                BAGELS_INFO.setText("Bagels:     Price: $5.00 - Stock: " + sm.inStock(102));
                WAFFLES_INFO.setText("Waffles:     Price: $6.50 - Stock: " + sm.inStock(105));
                MAPLE_SYRUP_INFO.setText("Maple Syrup:     Price: $15.00 - Stock: " + sm.inStock(107));

                ADD.setEnabled(true);
                REMOVE.setEnabled(false);

                ADD2.setEnabled(true);
                REMOVE2.setEnabled(false);

                ADD3.setEnabled(true);
                REMOVE3.setEnabled(false);

                ADD4.setEnabled(true);
                REMOVE4.setEnabled(false);

                ADD5.setEnabled(true);
                REMOVE5.setEnabled(false);

                ADD6.setEnabled(true);
                REMOVE6.setEnabled(false);

                ADD7.setEnabled(true);
                REMOVE7.setEnabled(false);
            }
        });
        return EMPTY_CART;
    }

    /**
     * Get a JButton that allows the user to view their cart
     *
     * @return JButton : a JButton object.
     */
    private JButton getViewCart() {

        JButton viewCart = new JButton("View Cart");

        viewCart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                StringBuilder sb = new StringBuilder();
                sb.append("------------The Food Store------------");
                sb.append("\n-----------------VIEW---------------------");
                sb.append("\nProduct Name | ID | Unit Price | Quantity\n");

                sb.append(sm.viewCart());

                INFO.setText(sb.toString());
                // items in the user's cart

            }
        });
        return viewCart;
    }

    /**
     * Get a JButton that allows the user to checkout
     *
     * @return JButton : a JButton object.
     */
    private JButton getCheckout() {

       CHECKOUT.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent actionEvent) {
               INFO.setText("My Cart:\n\n" + sm.checkout().toString());
                // displaying all the items in the cart and the total of them
                // after this button is clicked

               JOptionPane pane = new JOptionPane("Thank you for shopping at the Food Store! Have a great day!");
               JDialog d = pane.createDialog(null, "Thank you!");
               d.setLocation(850, 500);
               d.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
               d.setVisible(true);

               System.exit(0);
           }
       });

       return CHECKOUT;
    }

    /**
     * Get a JButton that allows the user to quit
     *
     * @return JButton : a JButton object.
     */
    public JButton getQuit() {
        JButton quit = new JButton("Quit");

        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (JOptionPane.showConfirmDialog(FRAME, "Are you sure you want to quit?")
                        == JOptionPane.OK_OPTION) {
                    // close it down!
                    FRAME.setVisible(false);
                    FRAME.dispose();
                }
            }
        });
        return quit;
    }

    /**
     * Get a JButton that adds potatoes to the user's cart upon their request
     *
     * @return JButton : a JButton object.
     */
    private JButton getAdd() {

        ADD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                INFO.setText("");
                while (true) {
                    try {
                        // while-loop true until user enters an appropriate amount to add to their cart
                        int value = Integer.parseInt(JOptionPane.showInputDialog("Choose the amount you would like to add"));

                        if (value < 0) {
                            JOptionPane.showMessageDialog(null, "Not a valid entry. Try again!");
                            continue;
                        }

                        boolean sufficientQuantity = sm.addToCart(101, value);

                        if (!sufficientQuantity) {
                            // if amount exceeds the number of items in the inventory
                            JOptionPane.showMessageDialog(null, "Sorry! There are not enough products in stock in the inventory!");
                        }

                        if (sm.inStock(101) == 0) {
                            // if no items are left in the inventory
                            ADD.setEnabled(false);
                        }

                        if (sm.getCart().size() != 0) {
                            // if there are items in the cart
                            EMPTY_CART.setEnabled(true);
                            CHECKOUT.setEnabled(true);
                        }

                        if (sm.inCart(101) != 0) {
                            // if this specific item is in the shopping cart
                            REMOVE.setEnabled(true);
                        }

                        break;
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "You must enter the amount that you would like to add");
                        // this will keep on displaying until the user enters an appropriate amount
                    }
                }
                POTATOES_INFO.setText("Potatoes:     Price: $4.00 - Stock: " + sm.inStock(101));
                // updating the inventory stock
            }
        });
        return ADD;
    }

    /**
     * Get a JButton that removes potatoes from the user's cart upon their request
     *
     * @return JButton : a JButton object.
     */
    private JButton getRemove() {

        REMOVE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                INFO.setText("");
                while(true) {
                    try {
                        // while-loop true until user enters an appropriate amount to remove from their cart
                        int value = Integer.parseInt(JOptionPane.showInputDialog("Choose the amount you would like to remove"));

                        if (value < 0) {
                            JOptionPane.showMessageDialog(null, "Not a valid entry. Try again!");
                            continue;
                        }

                        boolean sufficientQuantity = sm.removeFromCart(101, value);

                        if (!sufficientQuantity) {
                            // if amount exceeds number of items in the cart
                            JOptionPane.showMessageDialog(null, "Sorry! You do not have that many items in your cart.");
                        }

                        if (sm.inStock(101) != 0) {
                            // if there are items in the inventory
                            ADD.setEnabled(true);
                        }

                        if (sm.getCart().size() == 0) {
                            // if there are no items in the cart
                            EMPTY_CART.setEnabled(false);
                            CHECKOUT.setEnabled(false);
                        }

                        if (sm.inCart(101) == 0) {
                            // if this specific product is no longer in the cart
                            REMOVE.setEnabled(false);
                        }
                        break;
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "You must enter the amount that you would like to remove");
                        // this will keep on displaying until the user enters an appropriate amount
                    }
                }
                POTATOES_INFO.setText("Potatoes:     Price: $4.00 - Stock: " + sm.inStock(101));
                // updating the stock
            }
        });
        return REMOVE;
    }

    // All other Add and Remove buttons have the same functionality as the two above
    // Only difference is that a different product is being added to the cart
    // and removed from the cart

    /**
     * Get a JButton that adds bread to the user's cart upon their request
     *
     * @return JButton : a JButton object.
     */
    private JButton getAdd2() {

        ADD2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                INFO.setText("");
                while(true) {
                    try {
                        int value = Integer.parseInt(JOptionPane.showInputDialog("Choose the amount you would like to add"));

                        if (value < 0) {
                            JOptionPane.showMessageDialog(null, "Not a valid entry. Try again!");
                            continue;
                        }

                        boolean sufficientQuantity = sm.addToCart(106, value);

                        if (!sufficientQuantity) {
                            JOptionPane.showMessageDialog(null, "Sorry! There are not enough products in stock in the inventory!");
                        }

                        if (sm.inStock(106) == 0) {
                            ADD2.setEnabled(false);
                        }

                        if (sm.getCart().size() != 0) {
                            EMPTY_CART.setEnabled(true);
                            CHECKOUT.setEnabled(true);
                        }

                        if (sm.inCart(106) != 0) {
                            REMOVE2.setEnabled(true);
                        }

                        break;
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "You must enter the amount that you would like to add");
                    }
                }
                BREAD_INFO.setText("Bread:     Price: $7.00 - Stock: " + sm.inStock(106));
            }

        });
        return ADD2;
    }

    /**
     * Get a JButton that removes bread from the user's cart upon their request
     *
     * @return JButton : a JButton object.
     */
    private JButton getRemove2() {

        REMOVE2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                INFO.setText("");
                while(true) {
                    try {
                        int value = Integer.parseInt(JOptionPane.showInputDialog("Choose the amount you would like to remove"));

                        if (value < 0) {
                            JOptionPane.showMessageDialog(null, "Not a valid entry. Try again!");
                            continue;
                        }

                        boolean sufficientQuantity = sm.removeFromCart(106, value);

                        if (!sufficientQuantity) {
                            JOptionPane.showMessageDialog(null, "Sorry! You do not have that many items in your cart.");
                        }

                        if (sm.inStock(106) != 0) {
                            ADD2.setEnabled(true);
                        }

                        if (sm.getCart().size() == 0) {
                            EMPTY_CART.setEnabled(false);
                            CHECKOUT.setEnabled(false);
                        }

                        if (sm.inCart(106) == 0) {
                            REMOVE2.setEnabled(false);
                        }

                        break;
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "You must enter the amount that you would like to remove");
                    }
                }
                BREAD_INFO.setText("Bread:     Price: $7.00 - Stock: " + sm.inStock(106));
            }
        });
        return REMOVE2;
    }

    /**
     * Get a JButton that adds cereal to the user's cart upon their request
     *
     * @return JButton : a JButton object.
     */
    private JButton getAdd3() {

        ADD3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                INFO.setText("");
                while(true) {
                    try {
                        int value = Integer.parseInt(JOptionPane.showInputDialog("Choose the amount you would like to add"));

                        if (value < 0) {
                            JOptionPane.showMessageDialog(null, "Not a valid entry. Try again!");
                            continue;
                        }

                        boolean sufficientQuantity = sm.addToCart(103, value);

                        if (!sufficientQuantity) {
                            JOptionPane.showMessageDialog(null, "Sorry! There are not enough products in stock in the inventory!");
                        }

                        if (sm.inStock(103) == 0) {
                            ADD3.setEnabled(false);
                        }

                        if (sm.getCart().size() != 0) {
                            EMPTY_CART.setEnabled(true);
                            CHECKOUT.setEnabled(true);
                        }

                        if (sm.inCart(103) != 0) {
                            REMOVE3.setEnabled(true);
                        }

                        break;
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "You must enter the amount that you would like to add");
                    }
                }
                CEREAL_INFO.setText("Cereal:     Price: $6.00 - Stock: " + sm.inStock(103));
            }

        });
        return ADD3;
    }

    /**
     * Get a JButton that removes cereal from the user's cart upon their request
     *
     * @return JButton : a JButton object.
     */
    private JButton getRemove3() {

        REMOVE3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                INFO.setText("");
                while(true) {
                    try {
                        int value = Integer.parseInt(JOptionPane.showInputDialog("Choose the amount you would like to remove"));

                        if (value < 0) {
                            JOptionPane.showMessageDialog(null, "Not a valid entry. Try again!");
                            continue;
                        }

                        boolean sufficientQuantity = sm.removeFromCart(103, value);

                        if (!sufficientQuantity) {
                            JOptionPane.showMessageDialog(null, "Sorry! You do not have that many items in your cart.");
                        }

                        if (sm.inStock(103) != 0) {
                            ADD3.setEnabled(true);
                        }

                        if (sm.getCart().size() == 0) {
                            EMPTY_CART.setEnabled(false);
                            CHECKOUT.setEnabled(false);
                        }

                        if (sm.inCart(103) == 0) {
                            REMOVE3.setEnabled(false);
                        }

                        break;
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "You must enter the amount that you would like to remove");
                    }
                }
                CEREAL_INFO.setText("Cereal:     Price: $6.00 - Stock: " + sm.inStock(103));
            }
        });
        return REMOVE3;
    }

    /**
     * Get a JButton that adds oatmeal to the user's cart upon their request
     *
     * @return JButton : a JButton object.
     */
    private JButton getAdd4() {

        ADD4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                INFO.setText("");
                while(true) {
                    try {
                        int value = Integer.parseInt(JOptionPane.showInputDialog("Choose the amount you would like to add"));

                        if (value < 0) {
                            JOptionPane.showMessageDialog(null, "Not a valid entry. Try again!");
                            continue;
                        }

                        boolean sufficientQuantity = sm.addToCart(104, value);

                        if (!sufficientQuantity) {
                            JOptionPane.showMessageDialog(null, "Sorry! There are not enough products in stock in the inventory!");
                        }

                        if (sm.inStock(104) == 0) {
                            ADD4.setEnabled(false);
                        }

                        if (sm.getCart().size() != 0) {
                            EMPTY_CART.setEnabled(true);
                            CHECKOUT.setEnabled(true);
                        }

                        if (sm.inCart(104) != 0) {
                            REMOVE4.setEnabled(true);
                        }

                        break;
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "You must enter the amount that you would like to add");
                    }
                }
                OATMEAL_INFO.setText("Oatmeal:     Price: $4.50 - Stock: " + sm.inStock(104));
            }

        });
        return ADD4;
    }

    /**
     * Get a JButton that removes oatmeal from the user's cart upon their request
     *
     * @return JButton : a JButton object.
     */
    private JButton getRemove4() {

        REMOVE4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                INFO.setText("");
                while(true) {
                    try {
                        int value = Integer.parseInt(JOptionPane.showInputDialog("Choose the amount you would like to remove"));

                        if (value < 0) {
                            JOptionPane.showMessageDialog(null, "Not a valid entry. Try again!");
                            continue;
                        }

                        boolean sufficientQuantity = sm.removeFromCart(104, value);

                        if (!sufficientQuantity) {
                            JOptionPane.showMessageDialog(null, "Sorry! You do not have that many items in your cart.");
                        }

                        if (sm.inStock(104) != 0) {
                            ADD4.setEnabled(true);
                        }

                        if (sm.getCart().size() == 0) {
                            EMPTY_CART.setEnabled(false);
                            CHECKOUT.setEnabled(false);
                        }

                        if (sm.inCart(104) == 0) {
                            REMOVE4.setEnabled(false);
                        }

                        break;
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "You must enter the amount that you would like to remove");
                    }
                }
                OATMEAL_INFO.setText("Oatmeal:     Price: $4.50 - Stock: " + sm.inStock(104));
            }
        });
        return REMOVE4;
    }

    /**
     * Get a JButton that adds bagels to the user's cart upon their request
     *
     * @return JButton : a JButton object.
     */
    private JButton getAdd5() {

        ADD5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                INFO.setText("");
                while(true) {
                    try {
                        int value = Integer.parseInt(JOptionPane.showInputDialog("Choose the amount you would like to add"));

                        if (value < 0) {
                            JOptionPane.showMessageDialog(null, "Not a valid entry. Try again!");
                            continue;
                        }

                        boolean sufficientQuantity = sm.addToCart(102, value);

                        if (!sufficientQuantity) {
                            JOptionPane.showMessageDialog(null, "Sorry! There are not enough products in stock in the inventory!");
                        }

                        if (sm.inStock(102) == 0) {
                            ADD5.setEnabled(false);
                        }

                        if (sm.getCart().size() != 0) {
                            EMPTY_CART.setEnabled(true);
                            CHECKOUT.setEnabled(true);
                        }

                        if (sm.inCart(102) != 0) {
                            REMOVE5.setEnabled(true);
                        }

                        break;
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "You must enter the amount that you would like to add");
                    }
                }
                BAGELS_INFO.setText("Bagels:     Price: $5.00 - Stock: " + sm.inStock(102));
            }

        });
        return ADD5;
    }

    /**
     * Get a JButton that removes bagels from the user's cart upon their request
     *
     * @return JButton : a JButton object.
     */
    private JButton getRemove5() {

        REMOVE5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                INFO.setText("");
                while(true) {
                    try {
                        int value = Integer.parseInt(JOptionPane.showInputDialog("Choose the amount you would like to remove"));

                        if (value < 0) {
                            JOptionPane.showMessageDialog(null, "Not a valid entry. Try again!");
                            continue;
                        }

                        boolean sufficientQuantity = sm.removeFromCart(102, value);

                        if (!sufficientQuantity) {
                            JOptionPane.showMessageDialog(null, "Sorry! You do not have that many items in your cart.");
                        }

                        if (sm.inStock(102) != 0) {
                            ADD5.setEnabled(true);
                        }

                        if (sm.getCart().size() == 0) {
                            EMPTY_CART.setEnabled(false);
                            CHECKOUT.setEnabled(false);
                        }

                        if (sm.inCart(102) == 0) {
                            REMOVE5.setEnabled(false);
                        }

                        break;
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "You must enter the amount that you would like to remove");
                    }
                }
                BAGELS_INFO.setText("Bagels:     Price: $5.00 - Stock: " + sm.inStock(102));
            }
        });
        return REMOVE5;
    }

    /**
     * Get a JButton that adds waffles to the user's cart upon their request
     *
     * @return JButton : a JButton object.
     */
    private JButton getAdd6() {

        ADD6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                INFO.setText("");
                while(true) {
                    try {
                        int value = Integer.parseInt(JOptionPane.showInputDialog("Choose the amount you would like to add"));

                        if (value < 0) {
                            JOptionPane.showMessageDialog(null, "Not a valid entry. Try again!");
                            continue;
                        }

                        boolean sufficientQuantity = sm.addToCart(105, value);

                        if (!sufficientQuantity) {
                            JOptionPane.showMessageDialog(null, "Sorry! There are not enough products in stock in the inventory!");
                        }

                        if (sm.inStock(105) == 0) {
                            ADD6.setEnabled(false);
                        }

                        if (sm.getCart().size() != 0) {
                            EMPTY_CART.setEnabled(true);
                            CHECKOUT.setEnabled(true);
                        }

                        if (sm.inCart(105) != 0) {
                            REMOVE6.setEnabled(true);
                        }

                        break;
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "You must enter the amount that you would like to add");
                    }
                }
                WAFFLES_INFO.setText("Waffles:     Price: $6.50 - Stock: " + sm.inStock(105));
            }

        });

        return ADD6;
    }

    /**
     * Get a JButton that removes waffles from the user's cart upon their request
     *
     * @return JButton : a JButton object.
     */
    private JButton getRemove6() {

        REMOVE6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                INFO.setText("");
                while(true) {
                    try {
                        int value = Integer.parseInt(JOptionPane.showInputDialog("Choose the amount you would like to remove"));

                        if (value < 0) {
                            JOptionPane.showMessageDialog(null, "Not a valid entry. Try again!");
                            continue;
                        }

                        boolean sufficientQuantity = sm.removeFromCart(105, value);

                        if (!sufficientQuantity) {
                            JOptionPane.showMessageDialog(null, "Sorry! You do not have that many items in your cart.");
                        }

                        if (sm.inStock(105) != 0) {
                            ADD6.setEnabled(true);
                        }

                        if (sm.getCart().size() == 0) {
                            EMPTY_CART.setEnabled(false);
                            CHECKOUT.setEnabled(false);
                        }
                        if (sm.inCart(105) == 0) {
                            REMOVE6.setEnabled(false);
                        }

                        break;
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "You must enter the amount that you would like to remove");
                    }
                }
                WAFFLES_INFO.setText("Waffles:     Price: $6.50 - Stock: " + sm.inStock(105));
            }
        });

        return REMOVE6;

    }

    /**
     * Get a JButton that adds maple syrup to the user's cart upon their request
     *
     * @return JButton : a JButton object.
     */
    private JButton getAdd7() {

        ADD7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                INFO.setText("");
                while(true) {
                    try {
                        int value = Integer.parseInt(JOptionPane.showInputDialog("Choose the amount you would like to add"));

                        if (value < 0) {
                            JOptionPane.showMessageDialog(null, "Not a valid entry. Try again!");
                            continue;
                        }

                        boolean sufficientQuantity = sm.addToCart(107, value);

                        if (!sufficientQuantity) {
                            JOptionPane.showMessageDialog(null, "Sorry! There are not enough products in stock in the inventory!");
                        }

                        if (sm.inStock(107) == 0) {
                            ADD7.setEnabled(false);
                        }

                        if (sm.getCart().size() != 0) {
                            EMPTY_CART.setEnabled(true);
                            CHECKOUT.setEnabled(true);
                        }

                        if (sm.inCart(107) != 0) {
                            REMOVE7.setEnabled(true);
                        }

                        break;
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "You must enter the amount that you would like to add");
                    }
                }
                MAPLE_SYRUP_INFO.setText("Maple Syrup:     Price: $15.00 - Stock: " + sm.inStock(107));
            }

        });

        return ADD7;

    }

    /**
     * Get a JButton that removes maple syrup from the user's cart upon their request
     *
     * @return JButton : a JButton object.
     */
    private JButton getRemove7() {

        REMOVE7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                INFO.setText("");
                while(true) {
                    try {
                        int value = Integer.parseInt(JOptionPane.showInputDialog("Choose the amount you would like to remove"));

                        if (value < 0) {
                            JOptionPane.showMessageDialog(null, "Not a valid entry. Try again!");
                            continue;
                        }

                        boolean sufficientQuantity = sm.removeFromCart(107, value);

                        if (!sufficientQuantity) {
                            JOptionPane.showMessageDialog(null, "Sorry! You do not have that many items in your cart.");
                        }

                        if (sm.inStock(107) != 0) {
                            ADD7.setEnabled(true);
                        }

                        if (sm.getCart().size() == 0) {
                            EMPTY_CART.setEnabled(false);
                            CHECKOUT.setEnabled(false);
                        }

                        if (sm.inCart(101) == 0) {
                            REMOVE7.setEnabled(false);
                        }

                        break;
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "You must enter the amount that you would like to remove");
                    }
                }
                MAPLE_SYRUP_INFO.setText("Maple Syrup:     Price: $15.00 - Stock: " + sm.inStock(107));
            }
        });

        return REMOVE7;

    }

    /**
     * Get a JPanel that is the body panel
     * that contains the layout of the store
     *
     * @return JPanel : a JPanel object.
     */
    private JPanel getBody() {

        // main body panel where panel1 and
        JPanel bodyPanel = new JPanel(new GridLayout(1, 2));

        // panel1 below is used to store the information of the product
        // and the image of the product
        JPanel panel1 = new JPanel(new GridLayout(7, 2));

        // panel2 is where the buttons are stored
        // and where the text is displayed to the user
        JPanel panel2 = new JPanel(new BorderLayout());

        JPanel buttonPanel = new JPanel(new GridLayout(4, 1));
        // a panel where all the buttons will be stored

        // panels below are used so I can assign a new background color
        // for each product in the store
        JPanel p = new JPanel(new BorderLayout());
        JPanel p2 = new JPanel(new BorderLayout());

        JPanel b = new JPanel(new BorderLayout());
        JPanel b2 = new JPanel(new BorderLayout());

        JPanel c = new JPanel(new BorderLayout());
        JPanel c2 = new JPanel(new BorderLayout());

        JPanel o = new JPanel(new BorderLayout());
        JPanel o2 = new JPanel(new BorderLayout());

        JPanel bg = new JPanel(new BorderLayout());
        JPanel bg2 = new JPanel(new BorderLayout());

        JPanel w = new JPanel(new BorderLayout());
        JPanel w2 = new JPanel(new BorderLayout());

        JPanel ms = new JPanel(new BorderLayout());
        JPanel ms2 = new JPanel(new BorderLayout());

        // panels below are used for the buttons
        JPanel fl = new JPanel(new FlowLayout());
        JPanel fl2 = new JPanel(new FlowLayout());
        JPanel fl3 = new JPanel(new FlowLayout());
        JPanel fl4 = new JPanel(new FlowLayout());

        buttonPanel.add(fl);
        fl.add(getNewCartID());
        fl.add(getEmptyCart());

        buttonPanel.add(fl2);
        fl2.add(getViewCart());

        buttonPanel.add(fl3);
        fl3.add(getCheckout());

        buttonPanel.add(fl4);
        fl4.add(getQuit());


        // information about potatoes is added to a panel
        POTATOES_INFO.setLayout(new BorderLayout());
        POTATOES_INFO.setBackground(Color.CYAN);
        POTATOES_INFO.setText("Potatoes:     Price: $4.00 - Stock: " + sm.inStock(101));

        panel1.add(p);
        p.add(POTATOES_INFO, BorderLayout.CENTER);
        p.setBackground(Color.CYAN);

        JPanel bp = new JPanel(new GridLayout(1, 2));

        REMOVE.setEnabled(false);

        bp.add(getAdd());
        bp.add(getRemove());

        // image of potatoes is added to a panel
        // and the buttons to add/remove them
        JLabel potatoes = new JLabel();
        potatoes.setLayout(new FlowLayout());
        potatoes.setIcon(new ImageIcon(getClass().getResource("potatoes.jpg")));
        potatoes.add(bp, FlowLayout.LEFT);

        panel1.add(p2);
        p2.add(potatoes);
        p2.setBackground(Color.CYAN);

        // information about bread is added to a panel
        BREAD_INFO.setLayout(new BorderLayout());
        BREAD_INFO.setText("Bread:     Price: $7.00 - Stock: " + sm.inStock(106));

        panel1.add(b);
        b.add(BREAD_INFO, BorderLayout.CENTER);
        b.setBackground(Color.YELLOW);

        JPanel bp2 = new JPanel(new GridLayout(1, 2));

        REMOVE2.setEnabled(false);

        bp2.add(getAdd2());
        bp2.add(getRemove2());

        // image of bread is added to a panel
        // and the buttons to add/remove it
        JLabel bread = new JLabel();
        bread.setLayout(new FlowLayout());
        bread.setIcon(new ImageIcon(getClass().getResource("bread.jpg")));
        bread.add(bp2, FlowLayout.LEFT);

        panel1.add(b2);
        b2.add(bread);
        b2.setBackground(Color.YELLOW);

        // information about cereal is added to a panel
        CEREAL_INFO.setLayout(new BorderLayout());
        CEREAL_INFO.setText("Cereal:     Price: $6.00 - Stock: " + sm.inStock(103));

        panel1.add(c);
        c.add(CEREAL_INFO, BorderLayout.CENTER);
        c.setBackground(Color.PINK);

        JPanel bp3 = new JPanel(new GridLayout(1, 2));

        REMOVE3.setEnabled(false);

        bp3.add(getAdd3());
        bp3.add(getRemove3());

        // image of cereal is added to a panel
        // and the buttons to add/remove it
        JLabel cereal = new JLabel();
        cereal.setLayout(new FlowLayout());
        cereal.setIcon(new ImageIcon(getClass().getResource("cereal.jpg")));
        cereal.add(bp3, FlowLayout.LEFT);

        panel1.add(c2);
        c2.add(cereal);
        c2.setBackground(Color.PINK);

        // information about oatmeal is added to a panel
        OATMEAL_INFO.setLayout(new BorderLayout());
        OATMEAL_INFO.setText("Oatmeal:     Price: $4.50 - Stock: " + sm.inStock(104));

        panel1.add(o);
        o.add(OATMEAL_INFO, BorderLayout.CENTER);
        o.setBackground(Color.ORANGE);

        JPanel bp4 = new JPanel(new GridLayout(1, 2));

        REMOVE4.setEnabled(false);

        bp4.add(getAdd4());
        bp4.add(getRemove4());

        // image of oatmeal is added to a panel
        // and the buttons to add/remove it
        JLabel oatmeal = new JLabel();
        oatmeal.setLayout(new FlowLayout());
        oatmeal.setIcon(new ImageIcon(getClass().getResource("oatmeal.jpg")));
        oatmeal.add(bp4, FlowLayout.LEFT);

        panel1.add(o2);
        o2.add(oatmeal);
        o2.setBackground(Color.ORANGE);

        // information about bagels is added to a panel
        BAGELS_INFO.setLayout(new BorderLayout());
        BAGELS_INFO.setText("Bagels:     Price: $5.00 - Stock: " + sm.inStock(102));

        panel1.add(bg);
        bg.add(BAGELS_INFO, BorderLayout.CENTER);
        bg.setBackground(Color.GREEN);

        JPanel bp5 = new JPanel(new GridLayout(1, 2));

        REMOVE5.setEnabled(false);

        bp5.add(getAdd5());
        bp5.add(getRemove5());

        // image of bagels is added to a panel
        // and the buttons to add/remove them
        JLabel bagels = new JLabel();
        bagels.setLayout(new FlowLayout());
        bagels.setIcon(new ImageIcon(getClass().getResource("bagels.jpg")));
        bagels.add(bp5, FlowLayout.LEFT);

        panel1.add(bg2);
        bg2.add(bagels);
        bg2.setBackground(Color.GREEN);

        // information about waffles is added to a panel
        WAFFLES_INFO.setLayout(new BorderLayout());
        WAFFLES_INFO.setText("Waffles:     Price: $6.50 - Stock: " + sm.inStock(105));

        panel1.add(w);
        w.add(WAFFLES_INFO, BorderLayout.CENTER);
        w.setBackground(Color.LIGHT_GRAY);

        JPanel bp6 = new JPanel(new GridLayout(1, 2));

        REMOVE6.setEnabled(false);

        bp6.add(getAdd6());
        bp6.add(getRemove6());

        // image of waffles is added to a panel
        // and the buttons to add/remove them
        JLabel waffles = new JLabel();
        waffles.setLayout(new FlowLayout());
        waffles.setIcon(new ImageIcon(getClass().getResource("waffles.jpg")));
        waffles.add(bp6, FlowLayout.LEFT);

        panel1.add(w2);
        w2.add(waffles);
        w2.setBackground(Color.LIGHT_GRAY);

        // information about maple syrup is added to a panel
        MAPLE_SYRUP_INFO.setLayout(new BorderLayout());
        MAPLE_SYRUP_INFO.setText("Maple Syrup:     Price: $15.00 - Stock: " + sm.inStock(107));

        panel1.add(ms);
        ms.add(MAPLE_SYRUP_INFO, BorderLayout.CENTER);
        ms.setBackground(Color.MAGENTA);

        JPanel bp7 = new JPanel(new GridLayout(1, 2));

        REMOVE7.setEnabled(false);

        bp7.add(getAdd7());
        bp7.add(getRemove7());

        // image of maple syrup is added to a panel
        // and the buttons to add/remove it
        JLabel mapleSyrup = new JLabel();
        mapleSyrup.setLayout(new FlowLayout());
        mapleSyrup.setIcon(new ImageIcon(getClass().getResource("maplesyrup.jpg")));
        mapleSyrup.add(bp7, FlowLayout.LEFT);

        panel1.add(ms2);
        ms2.add(mapleSyrup);
        ms2.setBackground(Color.MAGENTA);

        panel2.add(buttonPanel, BorderLayout.NORTH);
        panel2.add(INFO, BorderLayout.CENTER);

        // adding a vertical and horizontal scrollbar if needed
        // lets the user see all the products in the store easily
        JScrollPane pane = new JScrollPane(panel1, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,  JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        pane.setMinimumSize(new Dimension(400, 800));
        pane.setPreferredSize(new Dimension(600, 500));
        bodyPanel.add(pane);

        bodyPanel.add(panel2);

        return bodyPanel;
    }

    /**
     * Displays the GUI of the Food Store
     */
    private void displayGUI() {
        // our main window
        EventQueue.invokeLater(() -> {
            showGUI();
        });

        JPanel panelFirst = new JPanel(new BorderLayout());
        JPanel mainPanel = new JPanel();

        mainPanel.add(panelFirst);
        // adding a panel to the main panel

        panelFirst.add(getHeader(), BorderLayout.PAGE_START);
        panelFirst.add(getBody(), BorderLayout.CENTER);
        // adding the header panel at the top of the panel
        // and the body panel in the center of the panel

        FRAME.add(mainPanel);
        // main panel added to the frame

        FRAME.pack();

        // ADD the window listener
        // we no longer want the frame to close immediately when we press "x"
        FRAME.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        FRAME.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                if (JOptionPane.showConfirmDialog(FRAME, "Are you sure you want to quit?")
                        == JOptionPane.OK_OPTION) {
                    // close it down!
                    FRAME.setVisible(false);
                    FRAME.dispose();
                }
            }
        });

        // the frame is not visible until we set it to be so
        FRAME.setVisible(true);

    }

    /**
     * Main method that instantiates a new StoreView object
     * to display the GUI of the store
     */
    public static void main(String[] args) {

        StoreManager sm = new StoreManager();
        StoreView sv = new StoreView(sm, sm.assignNewCartID());

        sv.displayGUI();

    }
}