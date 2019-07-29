CREATE TABLE `t_order` (
`id`  int NULL AUTO_INCREMENT ,
`amount`  int NULL DEFAULT '' COMMENT '金额' ,
`num`  int NULL DEFAULT '' COMMENT '数量' ,
PRIMARY KEY (`id`)
)
COMMENT='订单表'
;

