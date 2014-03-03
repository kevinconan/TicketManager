CREATE TABLE [dbo].[Ticket] (
    [TicketId]         INT          IDENTITY (1, 1) NOT NULL,
    [TicketTitle]      VARCHAR (50) NULL,
    [TicketScheduleId] INT          NULL,
    [SeatNo]           VARCHAR (50) NULL,
    [CustomerName]     VARCHAR (50) NULL,
    [TicketNo]         VARCHAR (50) NULL,
    [EntryTime]        DATETIME     CONSTRAINT [DF__Ticket__EntryTim__35BCFE0A] DEFAULT (getdate()) NULL,
    [DeadLine]         DATETIME     NULL,
    [Checked]          BIT          NULL,
    CONSTRAINT [PK__Ticket__712CC607EB882E3E] PRIMARY KEY CLUSTERED ([TicketId] ASC),
    CONSTRAINT [FK_Ticket_Schedule] FOREIGN KEY ([TicketScheduleId]) REFERENCES [dbo].[RouteSchedule] ([ScheduleId]),
    CONSTRAINT [UQ__Ticket__712CCE6569EDA9F2] UNIQUE NONCLUSTERED ([TicketNo] ASC)
);



GO
EXEC sp_addextendedproperty @name = N'MS_Description',
    @value = N'车票ID',
    @level0type = N'SCHEMA',
    @level0name = N'dbo',
    @level1type = N'TABLE',
    @level1name = N'Ticket',
    @level2type = N'COLUMN',
    @level2name = N'TicketId'
GO
EXEC sp_addextendedproperty @name = N'MS_Description',
    @value = N'车票标题',
    @level0type = N'SCHEMA',
    @level0name = N'dbo',
    @level1type = N'TABLE',
    @level1name = N'Ticket',
    @level2type = N'COLUMN',
    @level2name = N'TicketTitle'
GO
EXEC sp_addextendedproperty @name = N'MS_Description',
    @value = N'日程ID',
    @level0type = N'SCHEMA',
    @level0name = N'dbo',
    @level1type = N'TABLE',
    @level1name = N'Ticket',
    @level2type = N'COLUMN',
    @level2name = N'TicketScheduleId'
GO
EXEC sp_addextendedproperty @name = N'MS_Description',
    @value = N'座位号',
    @level0type = N'SCHEMA',
    @level0name = N'dbo',
    @level1type = N'TABLE',
    @level1name = N'Ticket',
    @level2type = N'COLUMN',
    @level2name = N'SeatNo'
GO
EXEC sp_addextendedproperty @name = N'MS_Description',
    @value = N'客户名称',
    @level0type = N'SCHEMA',
    @level0name = N'dbo',
    @level1type = N'TABLE',
    @level1name = N'Ticket',
    @level2type = N'COLUMN',
    @level2name = N'CustomerName'
GO
EXEC sp_addextendedproperty @name = N'MS_Description',
    @value = N'车票编号',
    @level0type = N'SCHEMA',
    @level0name = N'dbo',
    @level1type = N'TABLE',
    @level1name = N'Ticket',
    @level2type = N'COLUMN',
    @level2name = N'TicketNo'
GO
EXEC sp_addextendedproperty @name = N'MS_Description',
    @value = N'出票时间',
    @level0type = N'SCHEMA',
    @level0name = N'dbo',
    @level1type = N'TABLE',
    @level1name = N'Ticket',
    @level2type = N'COLUMN',
    @level2name = N'EntryTime'
GO
EXEC sp_addextendedproperty @name = N'MS_Description',
    @value = N'有效期',
    @level0type = N'SCHEMA',
    @level0name = N'dbo',
    @level1type = N'TABLE',
    @level1name = N'Ticket',
    @level2type = N'COLUMN',
    @level2name = 'DeadLine'
GO
EXEC sp_addextendedproperty @name = N'MS_Description',
    @value = N'是否检票',
    @level0type = N'SCHEMA',
    @level0name = N'dbo',
    @level1type = N'TABLE',
    @level1name = N'Ticket',
    @level2type = N'COLUMN',
    @level2name = N'Checked'