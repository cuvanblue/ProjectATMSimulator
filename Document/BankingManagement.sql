USE [master]
GO
/****** Object:  Database [BankingManagement]    Script Date: 12/13/2022 11:27:04 PM ******/
CREATE DATABASE [BankingManagement]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'BankingManagement', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.SERVER1\MSSQL\DATA\BankingManagement.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'BankingManagement_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.SERVER1\MSSQL\DATA\BankingManagement_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT, LEDGER = OFF
GO
ALTER DATABASE [BankingManagement] SET COMPATIBILITY_LEVEL = 160
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [BankingManagement].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [BankingManagement] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [BankingManagement] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [BankingManagement] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [BankingManagement] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [BankingManagement] SET ARITHABORT OFF 
GO
ALTER DATABASE [BankingManagement] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [BankingManagement] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [BankingManagement] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [BankingManagement] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [BankingManagement] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [BankingManagement] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [BankingManagement] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [BankingManagement] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [BankingManagement] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [BankingManagement] SET  DISABLE_BROKER 
GO
ALTER DATABASE [BankingManagement] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [BankingManagement] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [BankingManagement] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [BankingManagement] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [BankingManagement] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [BankingManagement] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [BankingManagement] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [BankingManagement] SET RECOVERY FULL 
GO
ALTER DATABASE [BankingManagement] SET  MULTI_USER 
GO
ALTER DATABASE [BankingManagement] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [BankingManagement] SET DB_CHAINING OFF 
GO
ALTER DATABASE [BankingManagement] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [BankingManagement] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [BankingManagement] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [BankingManagement] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'BankingManagement', N'ON'
GO
ALTER DATABASE [BankingManagement] SET QUERY_STORE = ON
GO
ALTER DATABASE [BankingManagement] SET QUERY_STORE (OPERATION_MODE = READ_WRITE, CLEANUP_POLICY = (STALE_QUERY_THRESHOLD_DAYS = 30), DATA_FLUSH_INTERVAL_SECONDS = 900, INTERVAL_LENGTH_MINUTES = 60, MAX_STORAGE_SIZE_MB = 1000, QUERY_CAPTURE_MODE = AUTO, SIZE_BASED_CLEANUP_MODE = AUTO, MAX_PLANS_PER_QUERY = 200, WAIT_STATS_CAPTURE_MODE = ON)
GO
USE [BankingManagement]
GO
/****** Object:  Table [dbo].[Admin]    Script Date: 12/13/2022 11:27:04 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Admin](
	[BankName] [char](10) NOT NULL,
	[account] [char](10) NOT NULL,
	[password] [char](10) NOT NULL,
 CONSTRAINT [PK_Admin] PRIMARY KEY CLUSTERED 
(
	[account] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ATM]    Script Date: 12/13/2022 11:27:04 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ATM](
	[ATMID] [char](10) NOT NULL,
	[Address] [nchar](50) NOT NULL,
	[BankName] [char](10) NOT NULL,
	[Cash] [int] NOT NULL,
	[q50] [int] NOT NULL,
	[q100] [int] NOT NULL,
	[q200] [int] NOT NULL,
	[q500] [int] NOT NULL,
	[Status] [bit] NOT NULL,
 CONSTRAINT [PK_ATM] PRIMARY KEY CLUSTERED 
(
	[ATMID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Bank]    Script Date: 12/13/2022 11:27:04 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Bank](
	[BankName] [char](10) NOT NULL,
	[withdrawFeeIn] [float] NOT NULL,
	[withdrawFeeOut] [float] NOT NULL,
	[transferFeeIn] [float] NULL,
	[transferFeeOut] [float] NULL,
 CONSTRAINT [PK_Bank] PRIMARY KEY CLUSTERED 
(
	[BankName] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[changepinTransaction]    Script Date: 12/13/2022 11:27:04 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[changepinTransaction](
	[ATMID] [char](10) NOT NULL,
	[TransactionID] [char](40) NOT NULL,
	[ATMnumber] [char](19) NOT NULL,
	[Time] [char](50) NOT NULL,
	[oldPIN] [char](6) NOT NULL,
	[newPIN] [char](6) NOT NULL,
	[Content] [nchar](200) NOT NULL,
 CONSTRAINT [PK_changepinTransaction] PRIMARY KEY CLUSTERED 
(
	[TransactionID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[checkbalanceTransaction]    Script Date: 12/13/2022 11:27:04 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[checkbalanceTransaction](
	[ATMID] [char](10) NOT NULL,
	[TransactionID] [char](40) NOT NULL,
	[ATMnumber] [char](19) NOT NULL,
	[Time] [char](50) NOT NULL,
	[Amount] [int] NOT NULL,
	[Content] [nchar](200) NOT NULL,
 CONSTRAINT [PK_checkbalanceTransaction] PRIMARY KEY CLUSTERED 
(
	[TransactionID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Customer]    Script Date: 12/13/2022 11:27:04 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Customer](
	[Name] [char](20) NOT NULL,
	[ID] [char](20) NOT NULL,
	[Birthday] [char](20) NOT NULL,
	[Phone] [char](10) NOT NULL,
	[Address] [nchar](50) NOT NULL,
	[Bank] [char](10) NOT NULL,
	[ATMnumber] [char](19) NOT NULL,
	[PIN] [char](6) NOT NULL,
	[Kind] [char](10) NOT NULL,
	[Status] [bit] NOT NULL,
	[ValidFrom] [char](20) NOT NULL,
	[GoodThru] [char](20) NOT NULL,
	[Balance] [bigint] NOT NULL,
 CONSTRAINT [PK_Customer_1] PRIMARY KEY CLUSTERED 
(
	[ATMnumber] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[statementTransaction]    Script Date: 12/13/2022 11:27:04 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[statementTransaction](
	[ATMID] [char](5) NOT NULL,
	[TransactionID] [char](40) NOT NULL,
	[ATMnumber] [char](19) NOT NULL,
	[Time] [char](50) NOT NULL,
	[Content] [nchar](200) NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[transferTransaction]    Script Date: 12/13/2022 11:27:04 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[transferTransaction](
	[ATMID] [char](10) NOT NULL,
	[transactionID] [char](40) NOT NULL,
	[ATMnumber] [char](19) NOT NULL,
	[Time] [char](50) NOT NULL,
	[Amount] [int] NOT NULL,
	[ATMnumber2] [char](19) NOT NULL,
	[Content] [nchar](200) NOT NULL,
 CONSTRAINT [PK_transferTransaction] PRIMARY KEY CLUSTERED 
(
	[transactionID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[withdrawTransaction]    Script Date: 12/13/2022 11:27:04 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[withdrawTransaction](
	[ATMID] [char](10) NOT NULL,
	[transactionID] [char](40) NOT NULL,
	[ATMnumber] [char](19) NOT NULL,
	[Time] [char](50) NOT NULL,
	[Amount] [int] NOT NULL,
	[Content] [nchar](200) NOT NULL,
 CONSTRAINT [PK_withdrawTransaction] PRIMARY KEY CLUSTERED 
(
	[transactionID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [IX_Customer]    Script Date: 12/13/2022 11:27:04 PM ******/
CREATE NONCLUSTERED INDEX [IX_Customer] ON [dbo].[Customer]
(
	[Name] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Admin]  WITH CHECK ADD  CONSTRAINT [FK_Admin_Bank] FOREIGN KEY([BankName])
REFERENCES [dbo].[Bank] ([BankName])
GO
ALTER TABLE [dbo].[Admin] CHECK CONSTRAINT [FK_Admin_Bank]
GO
ALTER TABLE [dbo].[ATM]  WITH CHECK ADD  CONSTRAINT [FK_ATM_Bank] FOREIGN KEY([BankName])
REFERENCES [dbo].[Bank] ([BankName])
GO
ALTER TABLE [dbo].[ATM] CHECK CONSTRAINT [FK_ATM_Bank]
GO
ALTER TABLE [dbo].[changepinTransaction]  WITH CHECK ADD  CONSTRAINT [FK_changepinTransaction_ATM] FOREIGN KEY([ATMID])
REFERENCES [dbo].[ATM] ([ATMID])
GO
ALTER TABLE [dbo].[changepinTransaction] CHECK CONSTRAINT [FK_changepinTransaction_ATM]
GO
ALTER TABLE [dbo].[changepinTransaction]  WITH CHECK ADD  CONSTRAINT [FK_changepinTransaction_Customer] FOREIGN KEY([ATMnumber])
REFERENCES [dbo].[Customer] ([ATMnumber])
GO
ALTER TABLE [dbo].[changepinTransaction] CHECK CONSTRAINT [FK_changepinTransaction_Customer]
GO
ALTER TABLE [dbo].[checkbalanceTransaction]  WITH CHECK ADD  CONSTRAINT [FK_checkbalanceTransaction_ATM] FOREIGN KEY([ATMID])
REFERENCES [dbo].[ATM] ([ATMID])
GO
ALTER TABLE [dbo].[checkbalanceTransaction] CHECK CONSTRAINT [FK_checkbalanceTransaction_ATM]
GO
ALTER TABLE [dbo].[checkbalanceTransaction]  WITH CHECK ADD  CONSTRAINT [FK_checkbalanceTransaction_Customer] FOREIGN KEY([ATMnumber])
REFERENCES [dbo].[Customer] ([ATMnumber])
GO
ALTER TABLE [dbo].[checkbalanceTransaction] CHECK CONSTRAINT [FK_checkbalanceTransaction_Customer]
GO
ALTER TABLE [dbo].[transferTransaction]  WITH CHECK ADD  CONSTRAINT [FK_transferTransaction_ATM] FOREIGN KEY([ATMID])
REFERENCES [dbo].[ATM] ([ATMID])
GO
ALTER TABLE [dbo].[transferTransaction] CHECK CONSTRAINT [FK_transferTransaction_ATM]
GO
ALTER TABLE [dbo].[transferTransaction]  WITH CHECK ADD  CONSTRAINT [FK_transferTransaction_Customer] FOREIGN KEY([ATMnumber])
REFERENCES [dbo].[Customer] ([ATMnumber])
GO
ALTER TABLE [dbo].[transferTransaction] CHECK CONSTRAINT [FK_transferTransaction_Customer]
GO
ALTER TABLE [dbo].[withdrawTransaction]  WITH CHECK ADD  CONSTRAINT [FK_withdrawTransaction_ATM] FOREIGN KEY([ATMID])
REFERENCES [dbo].[ATM] ([ATMID])
GO
ALTER TABLE [dbo].[withdrawTransaction] CHECK CONSTRAINT [FK_withdrawTransaction_ATM]
GO
ALTER TABLE [dbo].[withdrawTransaction]  WITH CHECK ADD  CONSTRAINT [FK_withdrawTransaction_Customer] FOREIGN KEY([ATMnumber])
REFERENCES [dbo].[Customer] ([ATMnumber])
GO
ALTER TABLE [dbo].[withdrawTransaction] CHECK CONSTRAINT [FK_withdrawTransaction_Customer]
GO
USE [master]
GO
ALTER DATABASE [BankingManagement] SET  READ_WRITE 
GO
