package Controller;

import Model.MiniMap;
import View.MiniMapView;

public class MiniMapController {
    MiniMap map;
    MiniMapView view;





    ////methods////
    public MiniMapController(MiniMap map)
    {
        this.map = map;
        this.view = new MiniMapView();

        view.showMiniMap(map);
    }
}
