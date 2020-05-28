安装注意：
1. 在Windows的Eclipse上面安装Checkstyle时候需要单独下载插件，因为Eclipse(Windows版本)得应用市场没有Checkstyle插件
2. CheckStyle在git commit前自动检查，只需要将当前目录下的pre-commit文件复制到./.git/hooks/文件夹中，在提交时候就会自动检查代码格式

开发工具插件安装注意事项：
1. 在Windows和Java平台都需要安装相应的插件才能在编辑代码的时候实现实时得检验代码质量
2. 在IDEA中注意配置文件和Checkstyle的版本对应，这非常重要，高版本的配置文件可以在GitHub中寻找：https://github.com/checkstyle/checkstyle