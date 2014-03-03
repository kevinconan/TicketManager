CREATE TABLE [dbo].[RouteSchedule] (
    [ScheduleId]        INT          NOT NULL,
    [ScheduleRouteId]   INT          NULL,
    [StartTime]         DATETIME     NULL,
    [EndTime]           DATETIME     NULL,
    [ScheduleName]      VARCHAR (50) NULL,
    [ScheduleVehicleNo] CHAR (10)    NULL,
    CONSTRAINT [PK__RouteSch__9C8A5B4980B9B9A7] PRIMARY KEY CLUSTERED ([ScheduleId] ASC),
    CONSTRAINT [FK_RouteSchedule_Bus] FOREIGN KEY ([ScheduleVehicleNo]) REFERENCES [dbo].[Bus] ([VehicleNo]),
    CONSTRAINT [FK_RouteSchedule_Route] FOREIGN KEY ([ScheduleRouteId]) REFERENCES [dbo].[Route] ([RouteId])
);





GO
EXEC sp_addextendedproperty @name = N'MS_Description',
    @value = N'日程ID',
    @level0type = N'SCHEMA',
    @level0name = N'dbo',
    @level1type = N'TABLE',
    @level1name = N'RouteSchedule',
    @level2type = N'COLUMN',
    @level2name = N'ScheduleId'
GO
EXEC sp_addextendedproperty @name = N'MS_Description',
    @value = N'线路ID',
    @level0type = N'SCHEMA',
    @level0name = N'dbo',
    @level1type = N'TABLE',
    @level1name = N'RouteSchedule',
    @level2type = N'COLUMN',
    @level2name = N'ScheduleRouteId'
GO
EXEC sp_addextendedproperty @name = N'MS_Description',
    @value = N'出发时间',
    @level0type = N'SCHEMA',
    @level0name = N'dbo',
    @level1type = N'TABLE',
    @level1name = N'RouteSchedule',
    @level2type = N'COLUMN',
    @level2name = N'StartTime'
GO
EXEC sp_addextendedproperty @name = N'MS_Description',
    @value = N'到达时间',
    @level0type = N'SCHEMA',
    @level0name = N'dbo',
    @level1type = N'TABLE',
    @level1name = N'RouteSchedule',
    @level2type = N'COLUMN',
    @level2name = N'EndTime'
GO
EXEC sp_addextendedproperty @name = N'MS_Description',
    @value = N'日程名称',
    @level0type = N'SCHEMA',
    @level0name = N'dbo',
    @level1type = N'TABLE',
    @level1name = N'RouteSchedule',
    @level2type = N'COLUMN',
    @level2name = N'ScheduleName'
GO
EXEC sp_addextendedproperty @name = N'MS_Description',
    @value = N'车牌号',
    @level0type = N'SCHEMA',
    @level0name = N'dbo',
    @level1type = N'TABLE',
    @level1name = N'RouteSchedule',
    @level2type = N'COLUMN',
    @level2name = N'ScheduleVehicleNo'