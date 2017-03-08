--alter table USER_LOGIN CHANGE UPNONE UPHONE VARCHAR(15)

select * from user_login
select * from user_info

SELECT UUID();
/**清除数据脚本**/
--用户登录
DELETE FROM user_login;
--用户信息
DELETE FROM user_info;
--博客
DELETE FROM blog;
--博客点赞
DELETE FROM blog_agree;
--博客评论信息
DELETE FROM blog_comment;
--模块信息
DELETE FROM module_info;
--笔记信息
DELETE FROM note_info;
--计划信息
DELETE FROM plan_info;
--字典信息
DELETE FROM sys_dict;
--系统交互表
DELETE FROM sys_interactive_log;
--用户操作
DELETE FROM sys_operate_log;
--任务信息
DELETE FROM task_info;

