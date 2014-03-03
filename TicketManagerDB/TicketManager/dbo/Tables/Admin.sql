CREATE TABLE [dbo].[Admin]
(
	[LoginId] VARCHAR(50) NOT NULL PRIMARY KEY, 
    [LoginPwd] CHAR(32) NOT NULL, 
    [AdminName] NVARCHAR(50) NULL
)

GO
EXEC sp_addextendedproperty @name = N'MS_Description',
    @value = N'管理员登录账号',
    @level0type = N'SCHEMA',
    @level0name = N'dbo',
    @level1type = N'TABLE',
    @level1name = N'Admin',
    @level2type = N'COLUMN',
    @level2name = N'LoginId'
GO
EXEC sp_addextendedproperty @name = N'MS_Description',
    @value = N'管理员登录密码（SHA1）',
    @level0type = N'SCHEMA',
    @level0name = N'dbo',
    @level1type = N'TABLE',
    @level1name = N'Admin',
    @level2type = N'COLUMN',
    @level2name = N'LoginPwd'
GO
EXEC sp_addextendedproperty @name = N'MS_Description',
    @value = N'管理员名称',
    @level0type = N'SCHEMA',
    @level0name = N'dbo',
    @level1type = N'TABLE',
    @level1name = N'Admin',
    @level2type = N'COLUMN',
    @level2name = N'AdminName'