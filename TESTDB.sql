use master
GO

CREATE DATABASE TESTDB
GO

use TESTDB
GO

CREATE TABLE users (
	[id] [varchar](36) NOT NULL,
	[name] [varchar](100) NOT NULL,
	[email] [varchar](50) NOT NULL,
	[createdon] [datetime] NOT NULL,
	[createdby] [varchar](250) NOT NULL,
	[modifiedon] [datetime] NULL,
	[modifiedby] [varchar](250) NULL,
 CONSTRAINT [PK_USERS] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO