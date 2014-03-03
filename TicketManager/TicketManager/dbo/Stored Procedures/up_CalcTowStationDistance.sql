CREATE PROCEDURE [dbo].[up_CalcTowStationDistance]
	@AStationId int,
	@BStationId int
AS
	DECLARE
		@AX float,
		@AY float,
		@BX float,
		@BY float

	SELECT 
		@AX=LocationX, @AY=LocationY
	FROM
		Station
	WHERE
		Station.StationId=@AStationId

	SELECT 
		@BX=LocationX, @BY=LocationY
	FROM
		Station
	WHERE
		Station.StationId=@BStationId

	DECLARE @distance float
	EXEC @distance = fn_CoordinateToDistance @AX,@AY,@BX,@BY
	SELECT @distance
RETURN 0
