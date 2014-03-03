CREATE FUNCTION [dbo].[fn_CoordinateToDistance]
(
	@coorAX float,
	@coorAY float,
	@coorBX float,
	@coorBY float
)
RETURNS float
AS
BEGIN
	DECLARE @r int
	SET @r = 6378137

	DECLARE @x1 FLOAT
	DECLARE @y1 FLOAT
	DECLARE @x2 FLOAT
	DECLARE @y2 FLOAT

	DECLARE @dx FLOAT
    DECLARE @dy FLOAT
 
    SET @x1 = RADIANS(@coorAX)
	SET @y1 = RADIANS(@coorAY)
    SET @x2 = RADIANS(@coorBX)
    SET @y2 = RADIANS(@coorBY)
 
    SET @dx = ABS (@x1 - @x2)
	SET @dy = ABS (@y1 - @y2)
	
	RETURN @r * 2 * ASIN(SQRT(POWER(SIN(@dx/2),2) + COS(@x1)*COS(@x2)*POWER(SIN(@dy/2),2)))
END
