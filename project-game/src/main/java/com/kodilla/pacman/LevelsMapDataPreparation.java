package com.kodilla.pacman;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LevelsMapDataPreparation {
    private final ArrayList<Point> availableSteps = new ArrayList<>();
    private Map<Point, Boolean> pointsToEat = new HashMap<>();

    public void preparePathway(int currentGameLevel, PacmanData pacmanData){
        if (currentGameLevel == 1)
            preparePathwayLevelFirst(pacmanData);
        else
            preparePathwayLevelSecond(pacmanData);
    }

    public void preparePathwayLevelFirst(PacmanData pacmanData) {
        for (int i = 13; i <= 793; i++) availableSteps.add(new Point(i, 13));
        for (int i = 13; i <= 793; i++) availableSteps.add(new Point(i, 293));
        for (int i = 14; i < 293; i++) availableSteps.add(new Point(793, i));
        for (int i = 14; i < 293; i++) availableSteps.add(new Point(13, i));

        for (int i = 14; i < 53; i++) availableSteps.add(new Point(133, i));
        for (int i = 14; i < 53; i++) availableSteps.add(new Point(253, i));
        for (int i = 14; i < 94; i++) availableSteps.add(new Point(313, i));

        for (int i = 14; i < 173; i++) availableSteps.add(new Point(353, i));
        for (int i = 14; i < 173; i++) availableSteps.add(new Point(393, i));
        for (int i = 14; i < 173; i++) availableSteps.add(new Point(433, i));

        for (int i = 14; i < 54; i++) availableSteps.add(new Point(473, i));
        for (int i = 94; i < 214; i++) availableSteps.add(new Point(473, i));

        for (int i = 14; i < 213; i++) availableSteps.add(new Point(633, i));

        for (int i = 133; i < 293; i++) availableSteps.add(new Point(313, i));
        for (int i = 133; i < 293; i++) availableSteps.add(new Point(133, i));
        for (int i = 94; i < 293; i++) availableSteps.add(new Point(53, i));
        for (int i = 54; i < 93; i++) availableSteps.add(new Point(73, i));
        for (int i = 94; i < 293; i++) availableSteps.add(new Point(93, i));

        for (int i = 14; i < 153; i++) availableSteps.add(new Point(673, i));
        for (int i = 14; i < 153; i++) availableSteps.add(new Point(733, i));
        for (int i = 154; i < 213; i++) availableSteps.add(new Point(753, i));

        for (int i = 254; i < 293; i++) availableSteps.add(new Point(753, i));
        for (int i = 254; i < 293; i++) availableSteps.add(new Point(593, i));
        for (int i = 214; i < 253; i++) availableSteps.add(new Point(533, i));
        for (int i = 54; i < 93; i++) availableSteps.add(new Point(193, i));
        for (int i = 94; i < 133; i++) availableSteps.add(new Point(233, i));

        for (int i = 14; i < 313; i++) availableSteps.add(new Point(i, 53));
        for (int i = 14; i < 313; i++) availableSteps.add(new Point(i, 93));
        for (int i = 94; i < 313; i++) availableSteps.add(new Point(i, 133));

        for (int i = 473; i < 633; i++) availableSteps.add(new Point(i, 53));
        for (int i = 473; i < 633; i++) availableSteps.add(new Point(i, 93));
        for (int i = 473; i < 633; i++) availableSteps.add(new Point(i, 133));
        for (int i = 313; i < 633; i++) availableSteps.add(new Point(i, 173));
        for (int i = 313; i <= 753; i++) availableSteps.add(new Point(i, 213));
        for (int i = 313; i <= 753; i++) availableSteps.add(new Point(i, 253));

        for (int i = 633; i < 793; i++) availableSteps.add(new Point(i, 153));

        for (int i = 13; i < 53; i++) availableSteps.add(new Point(i, 193));
        for (int i = 93; i < 133; i++) availableSteps.add(new Point(i, 193));
        for (int i = 53; i < 93; i++) availableSteps.add(new Point(i, 233));

        for (int i = 134; i < 173; i++) availableSteps.add(new Point(i, 213));
        for (int i = 174; i < 273; i++) availableSteps.add(new Point(i, 173));
        for (int i = 174; i < 273; i++) availableSteps.add(new Point(i, 253));
        for (int i = 274; i < 313; i++) availableSteps.add(new Point(i, 213));

        for (int i = 674; i < 733; i++) availableSteps.add(new Point(i, 73));
        for (int i = 734; i < 793; i++) availableSteps.add(new Point(i, 93));

        for (int i = 173; i <= 253; i++) availableSteps.add(new Point(173, i));
        for (int i = 173; i <= 253; i++) availableSteps.add(new Point(273, i));

        for (Point point : availableSteps) {
            if ((point.x - 13) % 20 == 0 && (point.y - 13) % 20 == 0)
                pointsToEat.put(point, true);
            else pointsToEat.put(point, false);
        }

        pacmanData.setPacmanCurrentLocation(pacmanData.getPacmanStartLocationLevelFirst());

        pointsToEat.put(pacmanData.getPacmanStartLocationLevelFirst(), false);
    }

    public void preparePathwayLevelSecond(PacmanData pacmanData) {
        for (int i = 13; i <= 793; i++) availableSteps.add(new Point(i, 13));
        for (int i = 13; i <= 793; i++) availableSteps.add(new Point(i, 293));
        for (int i = 14; i < 293; i++) availableSteps.add(new Point(793, i));
        for (int i = 14; i < 293; i++) availableSteps.add(new Point(13, i));

        for (int i = 93; i < 253; i++) availableSteps.add(new Point(53, i));
        for (int i = 14; i < 54; i++) availableSteps.add(new Point(53, i));
        for (int i = 14; i < 293; i++) availableSteps.add(new Point(113, i));
        for (int i = 113; i < 154; i++) availableSteps.add(new Point(153, i));
        for (int i = 14; i < 54; i++) availableSteps.add(new Point(173, i));
        for (int i = 93; i < 114; i++) availableSteps.add(new Point(173, i));
        for (int i = 234; i < 294; i++) availableSteps.add(new Point(173, i));
        for (int i = 54; i < 94; i++) availableSteps.add(new Point(193, i));
        for (int i = 194; i < 294; i++) availableSteps.add(new Point(213, i));
        for (int i = 113; i < 154; i++) availableSteps.add(new Point(233, i));
        for (int i = 14; i < 114; i++) availableSteps.add(new Point(253, i));
        for (int i = 154; i < 254; i++) availableSteps.add(new Point(273, i));
        for (int i = 53; i < 74; i++) availableSteps.add(new Point(293, i));
        for (int i = 114; i < 154; i++) availableSteps.add(new Point(313, i));
        for (int i = 194; i < 294; i++) availableSteps.add(new Point(313, i));
        for (int i = 114; i < 134; i++) availableSteps.add(new Point(313, i));
        for (int i = 93; i < 114; i++) availableSteps.add(new Point(333, i));
        for (int i = 73; i < 94; i++) availableSteps.add(new Point(353, i));
        for (int i = 234; i < 294; i++) availableSteps.add(new Point(373, i));
        for (int i = 14; i < 194; i++) availableSteps.add(new Point(393, i));
        for (int i = 194; i < 294; i++) availableSteps.add(new Point(413, i));
        for (int i = 14; i < 54; i++) availableSteps.add(new Point(433, i));
        for (int i = 93; i < 194; i++) availableSteps.add(new Point(433, i));
        for (int i = 194; i < 254; i++) availableSteps.add(new Point(453, i));
        for (int i = 14; i < 194; i++) availableSteps.add(new Point(493, i));
        for (int i = 194; i < 294; i++) availableSteps.add(new Point(513, i));
        for (int i = 113; i < 154; i++) availableSteps.add(new Point(533, i));
        for (int i = 14; i < 54; i++) availableSteps.add(new Point(553, i));
        for (int i = 93; i < 114; i++) availableSteps.add(new Point(553, i));
        for (int i = 54; i < 94; i++) availableSteps.add(new Point(573, i));
        for (int i = 194; i < 254; i++) availableSteps.add(new Point(573, i));
        for (int i = 113; i < 154; i++) availableSteps.add(new Point(613, i));
        for (int i = 194; i < 294; i++) availableSteps.add(new Point(613, i));
        for (int i = 14; i < 114; i++) availableSteps.add(new Point(633, i));
        for (int i = 154; i < 194; i++) availableSteps.add(new Point(673, i));
        for (int i = 234; i < 294; i++) availableSteps.add(new Point(673, i));
        for (int i = 53; i < 74; i++) availableSteps.add(new Point(693, i));
        for (int i = 194; i < 294; i++) availableSteps.add(new Point(713, i));
        for (int i = 114; i < 154; i++) availableSteps.add(new Point(713, i));
        for (int i = 93; i < 114; i++) availableSteps.add(new Point(733, i));
        for (int i = 73; i < 94; i++) availableSteps.add(new Point(753, i));

        for (int i = 54; i < 74; i++) availableSteps.add(new Point(i, 53));
        for (int i = 153; i < 194; i++) availableSteps.add(new Point(i, 53));
        for (int i = 294; i < 314; i++) availableSteps.add(new Point(i, 53));
        for (int i = 434; i < 454; i++) availableSteps.add(new Point(i, 53));
        for (int i = 533; i < 574; i++) availableSteps.add(new Point(i, 53));
        for (int i = 694; i < 714; i++) availableSteps.add(new Point(i, 53));

        for (int i = 194; i < 214; i++) availableSteps.add(new Point(i, 73));
        for (int i = 354; i < 394; i++) availableSteps.add(new Point(i, 73));
        for (int i = 254; i < 294; i++) availableSteps.add(new Point(i, 73));
        for (int i = 574; i < 594; i++) availableSteps.add(new Point(i, 73));
        for (int i = 634; i < 694; i++) availableSteps.add(new Point(i, 73));
        for (int i = 754; i < 794; i++) availableSteps.add(new Point(i, 73));

        for (int i = 54; i < 114; i++) availableSteps.add(new Point(i, 93));
        for (int i = 174; i < 194; i++) availableSteps.add(new Point(i, 93));
        for (int i = 334; i < 354; i++) availableSteps.add(new Point(i, 93));
        for (int i = 434; i < 494; i++) availableSteps.add(new Point(i, 93));
        for (int i = 554; i < 574; i++) availableSteps.add(new Point(i, 93));
        for (int i = 734; i < 754; i++) availableSteps.add(new Point(i, 93));

        for (int i = 14; i < 54; i++) availableSteps.add(new Point(i, 113));
        for (int i = 154; i < 174; i++) availableSteps.add(new Point(i, 113));
        for (int i = 234; i < 334; i++) availableSteps.add(new Point(i, 113));
        for (int i = 394; i < 434; i++) availableSteps.add(new Point(i, 113));
        for (int i = 534; i < 554; i++) availableSteps.add(new Point(i, 113));
        for (int i = 614; i < 734; i++) availableSteps.add(new Point(i, 113));

        for (int i = 54; i < 154; i++) availableSteps.add(new Point(i, 133));
        for (int i = 434; i < 534; i++) availableSteps.add(new Point(i, 133));

        for (int i = 154; i < 274; i++) availableSteps.add(new Point(i, 153));
        for (int i = 314; i < 394; i++) availableSteps.add(new Point(i, 153));
        for (int i = 534; i < 674; i++) availableSteps.add(new Point(i, 153));
        for (int i = 714; i < 794; i++) availableSteps.add(new Point(i, 153));

        for (int i = 14; i < 794; i++) availableSteps.add(new Point(i, 193));

        for (int i = 114; i < 214; i++) availableSteps.add(new Point(i, 233));
        for (int i = 314; i < 414; i++) availableSteps.add(new Point(i, 233));
        for (int i = 614; i < 714; i++) availableSteps.add(new Point(i, 233));

        for (int i = 14; i < 114; i++) availableSteps.add(new Point(i, 253));
        for (int i = 214; i < 314; i++) availableSteps.add(new Point(i, 253));
        for (int i = 414; i < 614; i++) availableSteps.add(new Point(i, 253));
        for (int i = 714; i < 794; i++) availableSteps.add(new Point(i, 253));


        for (Point point : availableSteps) {
            if ((point.x - 13) % 20 == 0 && (point.y - 13) % 20 == 0)
                pointsToEat.put(point, true);
            else pointsToEat.put(point, false);
        }

        pacmanData.setPacmanCurrentLocation(pacmanData.getPacmanStartLocationLevelSecond());

        pointsToEat.put(pacmanData.getPacmanStartLocationLevelSecond(), false);

    }

    public ArrayList<Point> getAvailableSteps() {
        return availableSteps;
    }

    public Map<Point, Boolean> getPointsToEat() {
        return pointsToEat;
    }
}
