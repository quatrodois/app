USE [master]
GO
/****** Object:  Database [Quatro]    Script Date: 10-12-2020 12:23:13 ******/
CREATE DATABASE [Quatro]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'Quatro', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLDEV2019\MSSQL\DATA\Quatro.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'Quatro_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLDEV2019\MSSQL\DATA\Quatro_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [Quatro] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Quatro].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Quatro] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [Quatro] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [Quatro] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [Quatro] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [Quatro] SET ARITHABORT OFF 
GO
ALTER DATABASE [Quatro] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [Quatro] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [Quatro] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [Quatro] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [Quatro] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [Quatro] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [Quatro] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [Quatro] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [Quatro] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [Quatro] SET  DISABLE_BROKER 
GO
ALTER DATABASE [Quatro] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [Quatro] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [Quatro] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [Quatro] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [Quatro] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [Quatro] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [Quatro] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [Quatro] SET RECOVERY FULL 
GO
ALTER DATABASE [Quatro] SET  MULTI_USER 
GO
ALTER DATABASE [Quatro] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [Quatro] SET DB_CHAINING OFF 
GO
ALTER DATABASE [Quatro] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [Quatro] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [Quatro] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'Quatro', N'ON'
GO
ALTER DATABASE [Quatro] SET QUERY_STORE = OFF
GO
USE [Quatro]
GO
/****** Object:  Table [dbo].[Certificate]    Script Date: 10-12-2020 12:23:14 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Certificate](
	[CertificateID] [int] NOT NULL,
	[Grade] [float] NULL,
	[SignatoryName] [varchar](50) NULL,
 CONSTRAINT [PK_Certificate] PRIMARY KEY CLUSTERED 
(
	[CertificateID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ContentItem]    Script Date: 10-12-2020 12:23:14 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ContentItem](
	[ContentItemID] [int] NOT NULL,
	[Status] [tinyint] NOT NULL,
	[PublicationDate] [date] NOT NULL,
	[Title] [varchar](50) NOT NULL,
	[Discription] [varchar](max) NULL,
 CONSTRAINT [PK_ContentItem] PRIMARY KEY CLUSTERED 
(
	[ContentItemID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Course]    Script Date: 10-12-2020 12:23:14 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Course](
	[CourseName] [varchar](50) NOT NULL,
	[Subject] [varchar](50) NOT NULL,
	[IntroductoryText] [varchar](max) NULL,
	[Difficulty] [varchar](50) NOT NULL,
 CONSTRAINT [PK_Course] PRIMARY KEY CLUSTERED 
(
	[CourseName] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CourseRecommended]    Script Date: 10-12-2020 12:23:14 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CourseRecommended](
	[CourseName] [varchar](50) NOT NULL,
	[CourseNameRecommended] [varchar](50) NOT NULL,
 CONSTRAINT [PK_CourseRecommended] PRIMARY KEY CLUSTERED 
(
	[CourseName] ASC,
	[CourseNameRecommended] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Module]    Script Date: 10-12-2020 12:23:14 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Module](
	[ContentItemID] [int] NOT NULL,
	[ContactName] [varchar](50) NOT NULL,
	[ContactEmail] [varchar](50) NOT NULL,
	[Version] [varchar](50) NOT NULL,
	[SerialNumber] [int] NOT NULL,
	[CourseName] [varchar](50) NULL,
 CONSTRAINT [PK_Module] PRIMARY KEY CLUSTERED 
(
	[ContentItemID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ModuleCompletion]    Script Date: 10-12-2020 12:23:14 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ModuleCompletion](
	[CertificateID] [int] NOT NULL,
	[CourseName] [varchar](50) NOT NULL,
	[PercentageCompleted] [float] NOT NULL,
 CONSTRAINT [PK_ModuleCompletion] PRIMARY KEY CLUSTERED 
(
	[CertificateID] ASC,
	[CourseName] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PercentageWatched]    Script Date: 10-12-2020 12:23:14 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PercentageWatched](
	[StudentEmail] [varchar](50) NOT NULL,
	[ContentItemID] [int] NOT NULL,
	[PercentageWatched] [float] NOT NULL,
 CONSTRAINT [PK_PercentageWatched] PRIMARY KEY CLUSTERED 
(
	[StudentEmail] ASC,
	[ContentItemID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Registration]    Script Date: 10-12-2020 12:23:14 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Registration](
	[StudentEmail] [varchar](50) NOT NULL,
	[CourseName] [varchar](50) NOT NULL,
	[RegistrationDate] [date] NOT NULL,
	[CertificateID] [int] NOT NULL,
 CONSTRAINT [PK_Registration] PRIMARY KEY CLUSTERED 
(
	[StudentEmail] ASC,
	[CourseName] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Student]    Script Date: 10-12-2020 12:23:14 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Student](
	[StudentEmail] [varchar](50) NOT NULL,
	[StudentName] [varchar](50) NOT NULL,
	[StudentBirthdate] [date] NOT NULL,
	[Gender] [varchar](50) NOT NULL,
	[Address] [varchar](max) NOT NULL,
	[City] [varchar](50) NOT NULL,
	[Country] [varchar](50) NOT NULL,
 CONSTRAINT [PK_Student] PRIMARY KEY CLUSTERED 
(
	[StudentEmail] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Webcast]    Script Date: 10-12-2020 12:23:14 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Webcast](
	[ContentItemID] [int] NOT NULL,
	[TimeSpan] [int] NOT NULL,
	[SpeakerName] [varchar](50) NOT NULL,
	[Organisation] [varchar](50) NULL,
	[URL] [varchar](max) NOT NULL,
 CONSTRAINT [PK_Webcast] PRIMARY KEY CLUSTERED 
(
	[ContentItemID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
ALTER TABLE [dbo].[CourseRecommended]  WITH CHECK ADD  CONSTRAINT [FK_CourseRecommended_Course] FOREIGN KEY([CourseName])
REFERENCES [dbo].[Course] ([CourseName])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[CourseRecommended] CHECK CONSTRAINT [FK_CourseRecommended_Course]
GO
ALTER TABLE [dbo].[CourseRecommended]  WITH CHECK ADD  CONSTRAINT [FK_CourseRecommended_Course1] FOREIGN KEY([CourseNameRecommended])
REFERENCES [dbo].[Course] ([CourseName])
GO
ALTER TABLE [dbo].[CourseRecommended] CHECK CONSTRAINT [FK_CourseRecommended_Course1]
GO
ALTER TABLE [dbo].[Module]  WITH CHECK ADD  CONSTRAINT [FK_Module_ContentItem] FOREIGN KEY([ContentItemID])
REFERENCES [dbo].[ContentItem] ([ContentItemID])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[Module] CHECK CONSTRAINT [FK_Module_ContentItem]
GO
ALTER TABLE [dbo].[Module]  WITH CHECK ADD  CONSTRAINT [FK_Module_Course] FOREIGN KEY([CourseName])
REFERENCES [dbo].[Course] ([CourseName])
ON UPDATE CASCADE
ON DELETE SET NULL
GO
ALTER TABLE [dbo].[Module] CHECK CONSTRAINT [FK_Module_Course]
GO
ALTER TABLE [dbo].[ModuleCompletion]  WITH CHECK ADD  CONSTRAINT [FK_ModuleCompletion_Certificate] FOREIGN KEY([CertificateID])
REFERENCES [dbo].[Certificate] ([CertificateID])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[ModuleCompletion] CHECK CONSTRAINT [FK_ModuleCompletion_Certificate]
GO
ALTER TABLE [dbo].[ModuleCompletion]  WITH CHECK ADD  CONSTRAINT [FK_ModuleCompletion_Course] FOREIGN KEY([CourseName])
REFERENCES [dbo].[Course] ([CourseName])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[ModuleCompletion] CHECK CONSTRAINT [FK_ModuleCompletion_Course]
GO
ALTER TABLE [dbo].[PercentageWatched]  WITH CHECK ADD  CONSTRAINT [FK_PercentageWatched_ContentItem] FOREIGN KEY([ContentItemID])
REFERENCES [dbo].[ContentItem] ([ContentItemID])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[PercentageWatched] CHECK CONSTRAINT [FK_PercentageWatched_ContentItem]
GO
ALTER TABLE [dbo].[PercentageWatched]  WITH CHECK ADD  CONSTRAINT [FK_PercentageWatched_Student] FOREIGN KEY([StudentEmail])
REFERENCES [dbo].[Student] ([StudentEmail])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[PercentageWatched] CHECK CONSTRAINT [FK_PercentageWatched_Student]
GO
ALTER TABLE [dbo].[Registration]  WITH CHECK ADD  CONSTRAINT [FK_Registration_Certificate] FOREIGN KEY([CertificateID])
REFERENCES [dbo].[Certificate] ([CertificateID])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[Registration] CHECK CONSTRAINT [FK_Registration_Certificate]
GO
ALTER TABLE [dbo].[Registration]  WITH CHECK ADD  CONSTRAINT [FK_Registration_Course] FOREIGN KEY([CourseName])
REFERENCES [dbo].[Course] ([CourseName])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[Registration] CHECK CONSTRAINT [FK_Registration_Course]
GO
ALTER TABLE [dbo].[Registration]  WITH CHECK ADD  CONSTRAINT [FK_Registration_Student] FOREIGN KEY([StudentEmail])
REFERENCES [dbo].[Student] ([StudentEmail])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[Registration] CHECK CONSTRAINT [FK_Registration_Student]
GO
ALTER TABLE [dbo].[Webcast]  WITH CHECK ADD  CONSTRAINT [FK_Webcast_ContentItem] FOREIGN KEY([ContentItemID])
REFERENCES [dbo].[ContentItem] ([ContentItemID])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[Webcast] CHECK CONSTRAINT [FK_Webcast_ContentItem]
GO
USE [master]
GO
ALTER DATABASE [Quatro] SET  READ_WRITE 
GO
