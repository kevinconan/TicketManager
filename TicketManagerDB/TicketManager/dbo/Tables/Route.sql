CREATE TABLE [dbo].[Route] (
    [RouteId]        INT           IDENTITY (1, 1) NOT NULL,
    [StartStationId] INT           NULL,
    [EndStationId]   INT           NULL,
    [RouteName]      NVARCHAR (50) NULL,
    CONSTRAINT [PK_Route] PRIMARY KEY CLUSTERED ([RouteId] ASC),
    CONSTRAINT [FK_Route_Station] FOREIGN KEY ([StartStationId]) REFERENCES [dbo].[Station] ([StationId]),
    CONSTRAINT [FK_Route_Station1] FOREIGN KEY ([EndStationId]) REFERENCES [dbo].[Station] ([StationId])
);


GO
EXEC sp_addextendedproperty @name = N'MS_Description',
    @value = N'线路ID',
    @level0type = N'SCHEMA',
    @level0name = N'dbo',
    @level1type = N'TABLE',
    @level1name = N'Route',
    @level2type = N'COLUMN',
    @level2name = N'RouteId'
GO
EXEC sp_addextendedproperty @name = N'MS_Description',
    @value = N'起点站ID',
    @level0type = N'SCHEMA',
    @level0name = N'dbo',
    @level1type = N'TABLE',
    @level1name = N'Route',
    @level2type = N'COLUMN',
    @level2name = N'StartStationId'
GO
EXEC sp_addextendedproperty @name = N'MS_Description',
    @value = N'终点站ID',
    @level0type = N'SCHEMA',
    @level0name = N'dbo',
    @level1type = N'TABLE',
    @level1name = N'Route',
    @level2type = N'COLUMN',
    @level2name = N'EndStationId'
GO
EXEC sp_addextendedproperty @name = N'MS_Description',
    @value = N'线路名称',
    @level0type = N'SCHEMA',
    @level0name = N'dbo',
    @level1type = N'TABLE',
    @level1name = N'Route',
    @level2type = N'COLUMN',
    @level2name = N'RouteName'