function calcStationDistance(cx1, cy1, cx2, cy2) {
    var x1, x2, y1, y2;

    x1 = cx1 * Math.PI / 180;
    x2 = cx2 * Math.PI / 180;
    y1 = cy1 * Math.PI / 180;
    y2 = cy2 * Math.PI / 180;

    var dx, dy;

    dx = Math.abs(x1 - x2);
    dy = Math.abs(y1 - y2);

    return 6378137
			* 2
			* Math.asin(Math.sqrt(Math.pow(Math.sin(dx / 2), 2) + Math.cos(x1)
					* Math.cos(x2) * Math.pow(Math.sin(dy / 2), 2)));
}