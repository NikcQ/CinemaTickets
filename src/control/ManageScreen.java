package control;

/**
 *
 * @author NikcQ
 */
import DAO.ScreenDAO;
import boundary.mainFrame;
import entity.CinemApp;
import entity.Screen;
import entity.Theater;
import java.util.ArrayList;

public class ManageScreen {

    private static CinemApp cinemapp = mainFrame.cinemapp;
    private static Theater teatro = mainFrame.cinemapp.getCinema();
    private static ScreenDAO screenDAO = mainFrame.screenDAO;

    // Control Strings
    private static String EMPTY_SCREEN_NAME = "The screen name must not be blank.";
    private static String BLOCK_DIMS = "Both dimensions of a block must be positive or zero.";
    private static String BLOCK_DIMS_GAVIP = "A screen must have a valid seat block.";
    private static String BLOCK_DIMS_4DX = "A 4DX screen must have a valid 4DX seat block.";
    private static String SCREEN_SUCCESS = "The screen was registered successfully.";

    public static String verificarScreen(String name, boolean is4D, int rowGA, int colGA, int rowVIP, int colVIP, int row4DX, int col4DX, boolean is3D) {
        Screen s;
        if (checkScreenName(name)) {
            if (is4D) {
                if (checkPositiveDim(row4DX, col4DX)) {
                    s = new Screen(0, 0, 0, 0, row4DX, col4DX, true, name);
                } else {
                    return BLOCK_DIMS_4DX;
                }
            } else {
                if (checkValidDim(rowGA, colGA) && checkValidDim(rowVIP, colVIP)) {
                    if (checkPositiveDim(rowGA, colGA) || checkPositiveDim(rowVIP, colVIP)) {
                        s = new Screen(rowGA, colGA, rowVIP, colVIP, 0, 0, is3D, name);
                    } else {
                        return BLOCK_DIMS_GAVIP;
                    }
                } else {
                    return BLOCK_DIMS;
                }
            }
            teatro.addScreen(s);
            screenDAO.create(s);
            return SCREEN_SUCCESS;
        } else {
            return EMPTY_SCREEN_NAME;
        }

    }

    public ManageScreen() {
    }

    public static boolean checkValidDim(int row, int col) {
        return (col > 0 && row > 0 || col == 0 && row == 0);
    }

    public static boolean checkPositiveDim(int row, int col) {
        return (col > 0 && row > 0);
    }

    public static boolean checkScreenName(String name) {
        return name.isEmpty() ? false : true;
    }

    public static void printScreen() {
        for (Screen screen : teatro.getScreens()) {
            System.out.println(screen.getName());
            System.out.println("---------------");
        }

    }

    public static ArrayList<String> getScreenNames() {
        ArrayList<Screen> list = mainFrame.cinemapp.getCinema().getScreens();
        ArrayList<String> names = new ArrayList<String>();
        for (Screen s : list) {
            names.add(s.getName());
        }
        return names;
    }

}
