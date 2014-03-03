CREATE TABLE [dbo].[Bus] (
    [VehicleNo]    NCHAR (7)     NOT NULL,
    [DriverName]   NVARCHAR (50) NULL,
    [SeatCount]    INT           NULL,
    [BusState]     INT           NULL,
    [BusStationId] INT           NULL,
    [BusRouteId]   INT           NULL,
    CONSTRAINT [PK_Bus] PRIMARY KEY CLUSTERED ([VehicleNo] ASC),
    CONSTRAINT [FK_Bus_Route] FOREIGN KEY ([BusRouteId]) REFERENCES [dbo].[Route] ([RouteId]),
    CONSTRAINT [FK_Bus_Station] FOREIGN KEY ([BusStationId]) REFERENCES [dbo].[Station] ([StationId])
);


GO
EXEC sp_addextendedproperty @name = N'MS_Description',
    @value = N'车牌号',
    @level0type = N'SCHEMA',
    @level0name = N'dbo',
    @level1type = N'TABLE',
    @level1name = N'Bus',
    @level2type = N'COLUMN',
    @level2name = N'VehicleNo'
GO
EXEC sp_addextendedproperty @name = N'MS_Description',
    @value = N'驾驶员名字',
    @level0type = N'SCHEMA',
    @level0name = N'dbo',
    @level1type = N'TABLE',
    @level1name = N'Bus',
    @level2type = N'COLUMN',
    @level2name = N'DriverName'
GO
EXEC sp_addextendedproperty @name = N'MS_Description',
    @value = N'座位数',
    @level0type = N'SCHEMA',
    @level0name = N'dbo',
    @level1type = N'TABLE',
    @level1name = N'Bus',
    @level2type = N'COLUMN',
    @level2name = N'SeatCount'
GO
EXEC sp_addextendedproperty @name = N'MS_Description',
    @value = N'客车状态',
    @level0type = N'SCHEMA',
    @level0name = N'dbo',
    @level1type = N'TABLE',
    @level1name = N'Bus',
    @level2type = N'COLUMN',
    @level2name = N'BusState'
GO
EXEC sp_addextendedproperty @name = N'MS_Description',
    @value = N'客车归属车站ID',
    @level0type = N'SCHEMA',
    @level0name = N'dbo',
    @level1type = N'TABLE',
    @level1name = N'Bus',
    @level2type = N'COLUMN',
    @level2name = N'BusStationId'
GO
EXEC sp_addextendedproperty @name = N'MS_Description',
    @value = N'客车默认路线ID',
    @level0type = N'SCHEMA',
    @level0name = N'dbo',
    @level1type = N'TABLE',
    @level1name = N'Bus',
    @level2type = N'COLUMN',
    @level2name = N'BusRouteId'