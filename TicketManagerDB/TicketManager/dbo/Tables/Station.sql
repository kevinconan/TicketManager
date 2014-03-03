CREATE TABLE [dbo].[Station] (
    [StationId]   INT          IDENTITY (1, 1) NOT NULL,
    [StationName] VARCHAR (50) NULL,
    [LocationX]   FLOAT (53)   NULL,
    [LocationY]   FLOAT (53)   NULL,
    CONSTRAINT [PK_Station] PRIMARY KEY CLUSTERED ([StationId] ASC)
);




GO
EXEC sp_addextendedproperty @name = N'MS_Description',
    @value = N'车站ID',
    @level0type = N'SCHEMA',
    @level0name = N'dbo',
    @level1type = N'TABLE',
    @level1name = N'Station',
    @level2type = N'COLUMN',
    @level2name = N'StationId'
GO
EXEC sp_addextendedproperty @name = N'MS_Description',
    @value = N'车站名称',
    @level0type = N'SCHEMA',
    @level0name = N'dbo',
    @level1type = N'TABLE',
    @level1name = N'Station',
    @level2type = N'COLUMN',
    @level2name = N'StationName'
GO
EXEC sp_addextendedproperty @name = N'MS_Description',
    @value = N'纬度',
    @level0type = N'SCHEMA',
    @level0name = N'dbo',
    @level1type = N'TABLE',
    @level1name = N'Station',
    @level2type = N'COLUMN',
    @level2name = N'LocationX'
GO
EXEC sp_addextendedproperty @name = N'MS_Description',
    @value = N'经度',
    @level0type = N'SCHEMA',
    @level0name = N'dbo',
    @level1type = N'TABLE',
    @level1name = N'Station',
    @level2type = N'COLUMN',
    @level2name = N'LocationY'